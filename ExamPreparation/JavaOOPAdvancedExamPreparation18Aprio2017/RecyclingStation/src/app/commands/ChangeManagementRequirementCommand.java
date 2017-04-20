package app.commands;

import app.models.station.RecyclingStation;
import app.waste_disposal.contracts.GarbageProcessor;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by vladix on 4/20/17.
 */
public class ChangeManagementRequirementCommand extends BaseCommand {

    private static final String MANAGEMENT_REQUIREMENT_CHANGED = "Management requirement changed!";

    public ChangeManagementRequirementCommand(RecyclingStation recyclingStation,
                                              GarbageProcessor garbageProcessor) {
        super(recyclingStation, garbageProcessor);
    }

    @Override
    public String execute(String[] tokens) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        super.getRecyclingStation().setFilter(tokens);

        return MANAGEMENT_REQUIREMENT_CHANGED;
    }
}
