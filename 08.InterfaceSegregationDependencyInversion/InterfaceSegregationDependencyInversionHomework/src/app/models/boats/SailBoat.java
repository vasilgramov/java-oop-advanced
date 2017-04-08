package app.models.boats;

import app.contracts.Race;

public class SailBoat extends AbstractBoat {
    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) {
        super(model, weight);
        this.sailEfficiency = sailEfficiency;
    }

    @Override
    protected void calcSpeed(Race race) {
        super.setSpeed(race.getWindSpeed() *
                (this.sailEfficiency / 100) -
                super.getWeight() +
                race.getOceanSpeed() / 5);
    }
}
