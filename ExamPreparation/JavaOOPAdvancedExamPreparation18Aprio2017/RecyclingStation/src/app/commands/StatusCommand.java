package app.commands;

import app.models.station.RecyclingStation;
import app.waste_disposal.contracts.GarbageProcessor;

/**
 * Created by vladix on 4/20/17.
 */
public class StatusCommand extends BaseCommand {


    public StatusCommand(RecyclingStation recyclingStation,
                         GarbageProcessor garbageProcessor) {
        super(recyclingStation, garbageProcessor);
    }

    public String execute(String[] tokens) {
        double currentBalance = super.getRecyclingStation().getCapital();
        double currentEnergy = super.getRecyclingStation().getEnergy();

        return String.format("Energy: %.2f Capital: %.2f", currentEnergy, currentBalance);
    }

}
