package app.models.wastes;

import app.waste_disposal.contracts.Waste;

/**
 * Created by vladix on 4/19/17.
 */
public abstract class BaseGarbage implements Waste {

    private String name;
    private double volumePerKG;
    private double weight;

    protected BaseGarbage(String name, double weight, double volumePerKG) {
        this.name = name;
        this.weight = weight;
        this.volumePerKG = volumePerKG;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getVolumePerKg() {
        return this.volumePerKG;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

}
