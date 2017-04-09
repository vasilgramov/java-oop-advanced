package app.models.boats;

import app.contracts.Race;

public class SailBoat extends AbstractBoat {
    private static final boolean HAS_MOTOR = false;

    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) {
        super(model, weight, HAS_MOTOR);
        this.sailEfficiency = sailEfficiency;
    }

    @Override
    public void calcSpeed(Race race) {
        super.setSpeed(race.getWindSpeed() *
                (this.sailEfficiency / 100) -
                super.getWeight() +
                race.getOceanSpeed() / 5);
    }
}
