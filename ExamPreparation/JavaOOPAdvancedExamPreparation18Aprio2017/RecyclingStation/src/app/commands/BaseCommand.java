package app.commands;

import app.models.station.RecyclingStation;
import app.waste_disposal.contracts.GarbageProcessor;

/**
 * Created by vladix on 4/20/17.
 */
public abstract class BaseCommand implements Executable {

    private RecyclingStation recyclingStation;
    private GarbageProcessor garbageProcessor;

    protected BaseCommand(RecyclingStation recyclingStation, GarbageProcessor garbageProcessor) {
        this.recyclingStation = recyclingStation;
        this.garbageProcessor = garbageProcessor;
    }

    protected RecyclingStation getRecyclingStation() {
        return this.recyclingStation;
    }

    protected GarbageProcessor getGarbageProcessor() {
        return this.garbageProcessor;
    }
}
