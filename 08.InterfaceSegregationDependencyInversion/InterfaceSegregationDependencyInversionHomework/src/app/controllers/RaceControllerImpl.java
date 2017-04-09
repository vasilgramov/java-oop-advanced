package app.controllers;

import app.exeptions.*;
import app.contracts.Boat;
import app.contracts.Database;
import app.contracts.Race;
import app.contracts.RaceController;
import app.enumeration.Leaderboard;
import app.models.races.RaceImpl;
import app.utility.Constants;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RaceControllerImpl implements RaceController {
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
                "A new race with distance %s meters, wind speed %sm/s and ocean current speed %s m/s has been set.",
                distance,
                windSpeed,
                oceanCurrentSpeed);
    }

    @Override
    public String signUpBoat(String model) throws NonExistantModelException, DuplicateModelException, NoSetRaceException {
        Boat boat = (Boat) this.database.getBoats().getItem(model); //  TODO: <--- im not like :) refactor RepositoryImpl

        this.validateRaceIsSet();

        if (this.currentRace.allowsMotorboats() && !boat.hasMotor()) {
            throw new IllegalArgumentException(Constants.IncorrectBoatTypeMessage);
        }

        boat.calcSpeed(this.currentRace);
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

        Map<Double, Boat> leaderboard = this.getLeaderboard(participants);

        final int[] position = { 0 };
        StringBuilder result = new StringBuilder();
        leaderboard.entrySet().stream()
                .limit(3)
                .forEach(p -> {
                    result.append(String.format("%s: %s Model: %s Time: %s",
                            Leaderboard.values()[position[0]++],
                            p.getValue().getClass().getSimpleName(),
                            p.getValue().getModel(),
                            this.hasFinished(p.getKey())));
                });

        this.closeRace();
        return result.toString();
    }

    private void closeRace() {
        this.currentRace = null;
    }

    private String hasFinished(Double time) {
        if (time == Double.NEGATIVE_INFINITY || time == 0.0) {
            return "Did not finish!";
        }

        return String.format("%f.2 sec", time);
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

    private Map<Double, Boat> getLeaderboard(List<Boat> participants) {
        Map<Double, Boat> leaderboard = new TreeMap<>();

        for (Boat participant : participants) {
            double time = this.currentRace.getDistance() / participant.getSped();

            leaderboard.put(time, participant);
        }

        return leaderboard;
    }
}
