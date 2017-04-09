package app.controllers.factories;

import app.contracts.Database;
import app.contracts.Modelable;
import app.database.DatabaseImpl;
import app.enumeration.BoatType;
import app.exeptions.NonExistantModelException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BoatFactory {

    public static Modelable createBoat(BoatType boatType, String[] ctor, Database database) throws ClassNotFoundException, NonExistantModelException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> boat = Class.forName(boatType.toString() + "Boat");

        Constructor<?> constructor = boat.getConstructors()[0];
        Object[] objects = new Object[constructor.getParameterCount()];

        Class<?>[] parameterTypes = constructor.getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            String parameterTypeName = parameterTypes[i].getSimpleName();
            switch (parameterTypeName) {
                case "Engine":
                    objects[i] = database.getEngines().getItem(ctor[i]);
                    break;
                case "String":
                    objects[i] = ctor[i];
                    break;
                case "int":
                    objects[i] = Integer.parseInt(ctor[i]);
                    break;
                case "double":
                    objects[i] = Double.parseDouble(ctor[i]);
                    break;
            }
        }

        Modelable modelable = (Modelable) constructor.newInstance(objects);

        return modelable;
    }
}
