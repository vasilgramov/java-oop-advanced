package app.models.engines;

import app.contracts.Engine;

public abstract class AbstractEngine implements Engine {
    private String model;
    private int horsePower;
    private int displacement;

    protected AbstractEngine(int horsePower, int displacement) {
        this.horsePower = horsePower;
        this.displacement = displacement;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getOutput() {
        return this.horsePower + this.displacement;
    }
}
