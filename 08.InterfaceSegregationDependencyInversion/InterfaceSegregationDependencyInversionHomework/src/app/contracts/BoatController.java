package app.contracts;

import app.enumeration.BoatType;
import app.enumeration.EngineType;
import app.exeptions.DuplicateModelException;
import app.exeptions.NonExistantModelException;

import java.lang.reflect.InvocationTargetException;

public interface BoatController {

    String createBoatEngine(EngineType engineType, String[] ctor)
            throws DuplicateModelException, IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException;

    String createBoat(BoatType boatType, String[] ctor)
            throws ClassNotFoundException, DuplicateModelException, InvocationTargetException, InstantiationException, IllegalAccessException, NonExistantModelException;

}
