package app.models.processors;

import app.waste_disposal.DefaultProcessingData;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.contracts.ProcessingData;

/**
 * Created by vladix on 4/19/17.
 */
public class RecyclableDisposalStrategy implements GarbageDisposalStrategy {

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double producedEnergy = 0;
        double usedEnergy = (garbage.getVolumePerKg() * garbage.getWeight()) / 2.0;
        double capitalEarned = garbage.getWeight() * 400;
        double capitalUsed = 0;

        return new DefaultProcessingData(producedEnergy - usedEnergy, capitalEarned - capitalUsed);
    }

}
