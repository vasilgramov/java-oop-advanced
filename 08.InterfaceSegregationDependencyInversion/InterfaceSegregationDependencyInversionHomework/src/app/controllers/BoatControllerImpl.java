package app.controllers;

import app.contracts.*;
import app.exeptions.*;
import app.controllers.factories.BoatFactory;
import app.controllers.factories.EngineFactory;
import app.enumeration.BoatType;
import app.enumeration.EngineType;

import java.util.*;
import java.lang.reflect.InvocationTargetException;

public class BoatControllerImpl implements BoatController {
    private Map<Double, Engine> map;
    private Database database;

    public BoatControllerImpl(Database database) {
        this.map = new HashMap<>();

        this.setDatabase(database);
    }

    private void setDatabase(Database database) {
        this.database = database;
    }

    @Override
    public String createBoatEngine(EngineType engineType, String[] ctor)
            throws DuplicateModelException, IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        Modelable engine = EngineFactory.createEngine(engineType, ctor);
        this.database.getEngines().add(engine);

        return String.format(
                "Engine model %s with %s HP and displacement %s cm3 created successfully.",
                ctor[0],
                ctor[1],
                ctor[2]);
    }

    @Override
    public String createBoat(BoatType boatType, String[] ctor)
            throws ClassNotFoundException, DuplicateModelException, InvocationTargetException, InstantiationException, IllegalAccessException, NonExistantModelException {
        Modelable boat = BoatFactory.createBoat(boatType, ctor, this.database);
        this.database.getBoats().add(boat);

        String boatTypePrint = boatType.toString().equals("Yacht") ? boatType.toString() : boatType.toString() + " boat";

        return String.format(
                "%s with model %s registered successfully.",
                boatTypePrint,
                boat.getModel());
    }
}
