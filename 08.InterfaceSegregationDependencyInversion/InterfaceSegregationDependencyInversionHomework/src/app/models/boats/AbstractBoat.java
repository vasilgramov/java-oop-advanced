package app.models.boats;

import app.contracts.Boat;
import app.contracts.Race;

public abstract class AbstractBoat implements Boat {
    private String model;
    private int weight;
    private int speed;
    private boolean hasMotor;

    protected AbstractBoat(String model, int weight, boolean hasMotor) {
        this.model = model;
        this.weight = weight;
        this.hasMotor = hasMotor;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public int getSped() {
        return this.speed;
    }

    @Override
    public boolean hasMotor() {
        return this.hasMotor;
    }

    protected void setSpeed(int speed) {
        this.speed = speed;
    }
}
