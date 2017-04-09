package app.models.engines;

import app.contracts.Engine;

public abstract class AbstractEngine implements Engine {
    private String model;
    private int horsePower;
    private int displacement;

    protected AbstractEngine(String model, int horsePower, int displacement) {
        this.model = model;
        this.horsePower = horsePower;
        this.displacement = displacement;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public double getOutput() {
        return this.horsePower + this.displacement;
    }
}
