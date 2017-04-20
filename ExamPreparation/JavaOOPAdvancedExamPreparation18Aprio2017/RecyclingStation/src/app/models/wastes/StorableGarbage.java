package app.models.wastes;

import app.waste_disposal.annotations.Storable;

/**
 * Created by vladix on 4/19/17.
 */

@Storable
public class StorableGarbage extends BaseGarbage {

    public StorableGarbage(String name, double weight, double volumePerKG) {
        super(name, weight, volumePerKG);
    }

}
