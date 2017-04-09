package app.core;

import app.contracts.BoatController;
import app.contracts.CommandHandler;
import app.contracts.Database;
import app.contracts.RaceController;
import app.controllers.BoatControllerImpl;
import app.controllers.RaceControllerImpl;
import app.enumeration.BoatType;
import app.enumeration.EngineType;
import app.exeptions.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class CommandHandlerImpl implements CommandHandler {
    private BoatController boatController;
    private RaceController raceController;

    public CommandHandlerImpl(Database database) {
        this.boatController = new BoatControllerImpl(database);
        this.raceController = new RaceControllerImpl(database);
    }

    public String executeCommand(List<String> parameters)
            throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException,
            InsufficientContestantsException, ClassNotFoundException, InvocationTargetException, InstantiationException,
            IllegalAccessException {
        String commandType = parameters.remove(0);
        switch (commandType) {
            case "CreateBoatEngine": {
                String remove = parameters.remove(parameters.size() - 1);
                EngineType engineType = EngineType.valueOf(remove);
                String[] ctor = parameters.toArray(new String[parameters.size()]);
                return this.boatController.createBoatEngine(engineType, ctor);
            }
            case "CreateRowBoat":
            case "CreateSailBoat":
            case "CreatePowerBoat":
            case "CreateYacht": {
                BoatType boatType = BoatType.valueOf(commandType.replace("Create", "").replace("Boat", ""));
                String[] ctor = parameters.toArray(new String[parameters.size()]);
                return this.boatController.createBoat(boatType, ctor);
            }
            case "OpenRace": {
                return this.raceController.openRace(
                        Integer.parseInt(parameters.get(0)),
                        Integer.parseInt(parameters.get(1)),
                        Integer.parseInt(parameters.get(2)),
                        Boolean.parseBoolean(parameters.get(3)));
            }
            case "SignUpBoat":
                return this.raceController.signUpBoat(parameters.get(0));
            case "StartRace":
                return this.raceController.startRace();
            case "GetStatistic":
                throw new UnsupportedOperationException("Not implemented");
            default:
                throw new IllegalArgumentException("Wrong command");
        }
    }
}
