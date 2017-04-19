package engines;

import commands.Executable;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by vladix on 4/18/17.
 */
public interface CommandInterpreter {

    Executable execute(String line) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;

}
