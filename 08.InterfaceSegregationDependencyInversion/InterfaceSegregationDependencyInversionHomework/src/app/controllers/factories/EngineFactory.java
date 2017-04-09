package app.controllers.factories;

import app.contracts.Modelable;
import app.enumeration.EngineType;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class EngineFactory {

    public static Modelable createEngine(EngineType engineType, String[] ctor) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> engine = Class.forName(engineType.toString() + "Engine");

        Constructor<?> constructor = engine.getConstructors()[0];
        Object[] objects = new Object[constructor.getParameterCount()];

        Class<?>[] parameterTypes = constructor.getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            String parameterTypeName = parameterTypes.getClass().getSimpleName();
            switch (parameterTypeName) {
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
