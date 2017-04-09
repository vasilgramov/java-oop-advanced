package app.contracts;

import app.exeptions.*;

public interface RaceController {


    String openRace(int distance, int windSpeed, int oceanCurrentSpeed, boolean allowsMotorboats)
            throws RaceAlreadyExistsException;

    String signUpBoat(String model) throws NonExistantModelException, DuplicateModelException, NoSetRaceException;

    String startRace() throws InsufficientContestantsException, NoSetRaceException;

    String getStatistic();
}
