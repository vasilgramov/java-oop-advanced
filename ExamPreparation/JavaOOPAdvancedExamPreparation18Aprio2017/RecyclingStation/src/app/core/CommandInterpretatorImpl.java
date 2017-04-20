package app.core;

import app.commands.BaseCommand;
import app.models.station.RecyclingStation;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.StrategyHolder;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by vladix on 4/19/17.
 */
public class CommandInterpretatorImpl implements CommandInterpretator {

    private static final String COMMANDS_PATH = "app.commands.";
    private static final String COMMAND = "Command";

    private GarbageProcessor garbageProcessor;
    private RecyclingStation recyclingStation;


    public CommandInterpretatorImpl(
            GarbageProcessor garbageProcessor,
            RecyclingStation recyclingStation) {
        this.garbageProcessor = garbageProcessor;
        this.recyclingStation = recyclingStation;
    }

    @Override
    public String execute(String line) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String[] tokens = line.split("\\s+|\\|");
        String commandType = tokens[0];

        Class<?> commandClass = Class.forName(COMMANDS_PATH + commandType + COMMAND);
        Constructor<?> constructor = commandClass.getConstructor(RecyclingStation.class, GarbageProcessor.class);
        BaseCommand baseCommand = ((BaseCommand) constructor.newInstance(this.recyclingStation, this.garbageProcessor));
        String result = baseCommand.execute(tokens);

        return result;
    }

}
