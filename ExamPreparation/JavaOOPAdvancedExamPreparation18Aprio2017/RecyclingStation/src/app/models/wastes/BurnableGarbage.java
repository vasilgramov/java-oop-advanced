package app.models.wastes;

import app.waste_disposal.annotations.Burnable;

/**
 * Created by vladix on 4/19/17.
 */

@Burnable
public class BurnableGarbage extends BaseGarbage {


    public BurnableGarbage(String name, double weight, double volumePerKG) {
        super(name, weight, volumePerKG);
    }
}
