package app.models.boats;

import app.contracts.Race;

public class RowBoat extends AbstractBoat {
    private int oars;

    public RowBoat(String model, int weight, int oars) {
        super(model, weight);
        this.oars = oars;
    }

    @Override
    public void calcSpeed(Race race) {
        super.setSpeed((this.oars * 100) -
                super.getWeight() +
                race.getOceanSpeed());
    }
}
