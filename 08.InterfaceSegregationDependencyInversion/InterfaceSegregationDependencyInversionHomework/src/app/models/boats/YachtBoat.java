package app.models.boats;

import app.contracts.Engine;
import app.contracts.Race;
import app.utility.Validator;

public class YachtBoat extends AbstractBoat {
    private static final boolean HAS_MOTOR = true;

    private int cargoWeight;
    private Engine engine;

    public YachtBoat(String model, int weight, Engine engine, int cargoWeight) {
        super(model, weight, HAS_MOTOR);

        this.setCargoWeight(cargoWeight);
        this.engine = engine;
    }

    public void setCargoWeight(int cargoWeight) {
        Validator.validatePropertyValue(cargoWeight, "Cargo Weight");

        this.cargoWeight = cargoWeight;
    }

    @Override
    public void calcSpeed(Race race) {
        super.setSpeed(this.engine.getOutput() -
                (super.getWeight() + this.cargoWeight) +
                race.getOceanSpeed()/ 2.0);
    }
}
