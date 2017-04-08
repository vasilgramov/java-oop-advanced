package app.models.boats;


import app.contracts.Engine;
import app.contracts.Race;

public class PowerBoat extends AbstractBoat {
    private Engine[] engines;

    protected PowerBoat(String model, int weight, Engine engine1, Engine engine2) {
        super(model, weight);
        this.engines = new Engine[2];
        this.engines[0] = engine1;
        this.engines[1] = engine2;
    }

    @Override
    public void calcSpeed(Race race) {
        super.setSpeed((this.engines[0].getOutput() + this.engines[1].getOutput()) -
                super.getWeight() +
                (race.getOceanSpeed() / 5));
    }
}
