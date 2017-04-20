package app.waste_disposal;

import app.waste_disposal.contracts.ProcessingData;

/**
 * Created by vladix on 4/19/17.
 */
public class DefaultProcessingData implements ProcessingData {

    private double energyBalance;
    private double capitalBalance;

    public DefaultProcessingData(double energyBalance, double capitalBalance) {
        this.energyBalance = energyBalance;
        this.capitalBalance = capitalBalance;
    }

    @Override
    public double getEnergyBalance() {
        return this.energyBalance;
    }

    @Override
    public double getCapitalBalance() {
        return this.capitalBalance;
    }

}
