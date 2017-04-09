package app.models.boats;

import app.contracts.Engine;
import app.contracts.Race;

public class YachtBoat extends AbstractBoat {
    private static final boolean HAS_MOTOR = true;

    private int cargoWeight;
    private Engine engine;

    protected YachtBoat(String model, int weight, int cargoWeight, Engine engine) {
        super(model, weight, HAS_MOTOR);

        this.cargoWeight = cargoWeight;
        this.engine =engine;
    }

    @Override
    public void calcSpeed(Race race) {
        super.setSpeed(this.engine.getOutput() -
                (super.getWeight() + this.cargoWeight) +
                race.getOceanSpeed()/ 2);
    }
}
