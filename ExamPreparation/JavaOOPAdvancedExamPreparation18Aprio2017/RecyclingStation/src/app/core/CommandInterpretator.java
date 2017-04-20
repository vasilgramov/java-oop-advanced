package app.core;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by vladix on 4/19/17.
 */
public interface CommandInterpretator {

    String execute(String line) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;

}
