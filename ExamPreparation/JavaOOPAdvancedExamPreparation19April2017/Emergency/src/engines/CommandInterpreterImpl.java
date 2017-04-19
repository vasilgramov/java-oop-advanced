package engines;

import commands.Executable;
import core.ManagementSystem;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by vladix on 4/18/17.
 */
public class CommandInterpreterImpl implements CommandInterpreter {

    private static final String COMMAND = "Command";
    private static final String COMMANDS_PATH = "commands.";

    private ManagementSystem emergencyManagementSystem;

    public CommandInterpreterImpl(ManagementSystem emergencyManagementSystem) {
        this.emergencyManagementSystem = emergencyManagementSystem;
    }

    @Override
    public Executable execute(String commandType)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Executable> exeClass = (Class<Executable>) Class.forName(COMMANDS_PATH + commandType + COMMAND);
        Constructor<Executable> constructor = exeClass.getConstructor(ManagementSystem.class);
        Executable executable = constructor.newInstance(this.emergencyManagementSystem);

        return executable;
    }
}
