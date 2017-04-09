package app.models.boats;


import app.contracts.Engine;
import app.contracts.Race;

public class PowerBoat extends AbstractBoat {
    private static final boolean HAS_MOTOR = true;

    private Engine[] engines;

    public PowerBoat(String model, int weight, Engine engine1, Engine engine2) {
        super(model, weight, HAS_MOTOR);
        this.engines = new Engine[2];
        this.engines[0] = engine1;
        this.engines[1] = engine2;
    }

    @Override
    public void calcSpeed(Race race) {
        super.setSpeed((this.engines[0].getOutput() + this.engines[1].getOutput()) -
                super.getWeight() +
                (race.getOceanSpeed() / 5.0));
    }
}
