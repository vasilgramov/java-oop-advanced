package app.models.processors;

import app.waste_disposal.DefaultProcessingData;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.contracts.ProcessingData;

/**
 * Created by vladix on 4/19/17.
 */
public class StorableDisposalStrategy implements GarbageDisposalStrategy {

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double producedEnergy = 0;
        double usedEnergy = (garbage.getVolumePerKg() * garbage.getWeight()) * 13.0 / 100.0;
        double earnedCapital = 0;
        double usedCapital = (garbage.getWeight() * garbage.getVolumePerKg()) * 65.0 / 100.0;

        return new DefaultProcessingData(producedEnergy - usedEnergy, earnedCapital - usedCapital);
    }

}
