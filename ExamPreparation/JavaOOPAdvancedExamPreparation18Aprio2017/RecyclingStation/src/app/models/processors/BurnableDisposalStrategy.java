package app.models.processors;

import app.waste_disposal.DefaultProcessingData;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.contracts.ProcessingData;

/**
 * Created by vladix on 4/19/17.
 */
public class BurnableDisposalStrategy implements GarbageDisposalStrategy {

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double producedEnergy = garbage.getVolumePerKg() * garbage.getWeight();
        double usedEnergy = (garbage.getVolumePerKg() * garbage.getWeight()) / 5.0;
        double capitalEarned = 0;
        double capitalUsed = 0;

        return new DefaultProcessingData(producedEnergy - usedEnergy, capitalEarned - capitalUsed);
    }

}
