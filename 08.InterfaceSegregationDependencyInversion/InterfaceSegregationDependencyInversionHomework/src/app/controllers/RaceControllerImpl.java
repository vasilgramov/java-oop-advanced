package app.controllers;

import app.exeptions.*;
import app.contracts.Boat;
import app.contracts.Database;
import app.contracts.Race;
import app.contracts.RaceController;
import app.enumeration.Leaderboard;
import app.models.races.RaceImpl;
import app.utility.Constants;

import java.util.*;

public class RaceControllerImpl implements RaceController {
    private static final double HAS_NOT_FINISHED = 2017.17;

    private Race currentRace;
    private Database database;

    public RaceControllerImpl(Database database) {
        this.database = database;
    }

    @Override
    public String openRace(int distance, int windSpeed, int oceanCurrentSpeed, boolean allowsMotorboats)
            throws RaceAlreadyExistsException {
        Race race = new RaceImpl(distance, windSpeed, oceanCurrentSpeed, allowsMotorboats);

        this.validateRaceIsEmpty();

        this.currentRace = race;

        return String.format(
                "A new race with distance %s meters, wind speed %s m/s and ocean current speed %s m/s has been set.",
                distance,
                windSpeed,
                oceanCurrentSpeed);
    }

    @Override
    public String signUpBoat(String model) throws NonExistantModelException, DuplicateModelException, NoSetRaceException {
        Boat boat = (Boat) this.database.getBoats().getItem(model); //  TODO: <--- im not like :) refactor RepositoryImpl

        this.validateRaceIsSet();

        if (!this.currentRace.allowsMotorboats() && boat.hasMotor()) {
            throw new IllegalArgumentException(Constants.IncorrectBoatTypeMessage);
        }

        this.currentRace.addParticipant(boat);

        return String.format(
                "Boat with model %s has signed up for the current Race.",
                boat.getModel());
    }

    @Override
    public String startRace() throws InsufficientContestantsException, NoSetRaceException {
        this.validateRaceIsSet();

        List<Boat> participants = this.currentRace.getParticipants();
        if (participants.size() < 3) {
            throw new InsufficientContestantsException(Constants.InsufficientContestantsMessage);
        }

        Map<Boat, Double> leaderboard = this.getLeaderboard(participants);

        final int[] position = { 0 };
        StringBuilder result = new StringBuilder();
        leaderboard.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .limit(3)
                .forEach(p -> {
                    result.append(String.format("%s place: %s Model: %s Time: %s",
                            Leaderboard.values()[position[0]++],
                            p.getKey().getClass().getSimpleName(),
                            p.getKey().getModel(),
                            this.hasFinished(p.getValue())))
                    .append(System.lineSeparator());
                });

        this.closeRace();
        return result.toString();
    }

    private void closeRace() {
        this.currentRace = null;
    }

    private String hasFinished(double time) {
        if (time == HAS_NOT_FINISHED || time <= 0.0) {
            return "Did not finish!";
        }

        return String.format("%.2f sec", time);
    }

    private void validateRaceIsSet() throws NoSetRaceException {
        if (this.currentRace == null) {
            throw new NoSetRaceException(Constants.NoSetRaceMessage);
        }
    }

    private void validateRaceIsEmpty() throws RaceAlreadyExistsException {
        if (this.currentRace != null) {
            throw new RaceAlreadyExistsException(Constants.RaceAlreadyExistsMessage);
        }
    }

    private Map<Boat, Double> getLeaderboard(List<Boat> participants) {
        Map<Boat, Double> leaderboard = new LinkedHashMap<>();

        for (Boat participant : participants) {
            participant.calcSpeed(this.currentRace);

            double time = this.currentRace.getDistance() / participant.getSped();
            if (time <= 0) {
                time = HAS_NOT_FINISHED;
            }

            leaderboard.put(participant, time);
        }

        return leaderboard;
    }
}
