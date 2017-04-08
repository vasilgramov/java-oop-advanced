package app.models.boats;

import app.contracts.Boat;
import app.contracts.Race;

public abstract class AbstractBoat implements Boat {
    private String model;
    private int weight;
    private int speed;

    protected AbstractBoat(String model, int weight) {
        this.model = model;
        this.weight = weight;
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

    protected void setSpeed(int speed) {
        this.speed = speed;
    }

    protected abstract void calcSpeed(Race race);
}
