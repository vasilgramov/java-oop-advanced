package app.models.wastes;

import app.waste_disposal.annotations.Recyclable;

/**
 * Created by vladix on 4/19/17.
 */

@Recyclable
public class RecyclableGarbage extends BaseGarbage {

    public RecyclableGarbage(String name, double weight, double volumePerKG) {
        super(name, weight, volumePerKG);
    }

}
