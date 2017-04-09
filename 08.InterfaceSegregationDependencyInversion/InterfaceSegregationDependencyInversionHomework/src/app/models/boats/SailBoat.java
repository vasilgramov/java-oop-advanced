package app.models.boats;

import app.contracts.Race;
import app.utility.Constants;

public class SailBoat extends AbstractBoat {
    private static final boolean HAS_MOTOR = false;

    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) {
        super(model, weight, HAS_MOTOR);
        this.setSailEfficiency(sailEfficiency);
    }

    private void setSailEfficiency(int sailEfficiency) {
        if (sailEfficiency < 1 || sailEfficiency > 100) {
            throw new IllegalArgumentException(Constants.IncorrectSailEfficiencyMessage);
        }

        this.sailEfficiency = sailEfficiency;
    }

    @Override
    public void calcSpeed(Race race) {
        super.setSpeed(race.getWindSpeed() *
                (this.sailEfficiency / 100.0) -
                super.getWeight() +
                (race.getOceanSpeed() / 2.0));
    }
}
