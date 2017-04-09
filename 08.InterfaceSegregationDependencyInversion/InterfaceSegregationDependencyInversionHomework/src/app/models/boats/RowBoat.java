package app.models.boats;

import app.contracts.Race;
import app.utility.Validator;

public class RowBoat extends AbstractBoat {
    private static final boolean HAS_MOTOR = false;

    private int oars;

    public RowBoat(String model, int weight, int oars) {
        super(model, weight, HAS_MOTOR);
        this.setOars(oars);
    }

    private void setOars(int oars) {
        Validator.validatePropertyValue(oars, "Oars");

        this.oars = oars;
    }

    @Override
    public void calcSpeed(Race race) {
        super.setSpeed((this.oars * 100.0) -
                super.getWeight() +
                race.getOceanSpeed());
    }
}
