package app.models.boats;

import app.contracts.Engine;
import app.contracts.Race;

public class Yacht extends AbstractBoat {
    private int cargoWeight;
    private Engine engine;

    protected Yacht(String model, int weight, int cargoWeight, Engine engine) {
        super(model, weight);

        this.cargoWeight = cargoWeight;
        this.engine =engine;
    }

    @Override
    protected void calcSpeed(Race race) {
        super.setSpeed(this.engine.getOutput() -
                (super.getWeight() + this.cargoWeight) +
                race.getOceanSpeed()/ 2);
    }
}
