package app.models.station;

import app.waste_disposal.contracts.ProcessingData;

/**
 * Created by vladix on 4/20/17.
 */
public class RecyclingStationImpl implements RecyclingStation {

    private double energy;
    private double capital;

    private String filter;
    private double minEnergy;
    private double mingCapital;

    @Override
    public double getEnergy() {
        return this.energy;
    }

    @Override
    public double getCapital() {
        return this.capital;
    }

    @Override
    public void processData(ProcessingData data) {
            double capitalBalance = data.getCapitalBalance();
            double energyBalance = data.getEnergyBalance();

            this.energy += energyBalance;
            this.capital += capitalBalance;
    }

    @Override
    public String getFilter() {
        return this.filter;
    }

    @Override
    public void setFilter(String[] filterData) {
        this.filter = filterData[3];
        this.minEnergy = Double.parseDouble(filterData[1]);
        this.mingCapital = Double.parseDouble(filterData[2]);
    }

    @Override
    public double getMinEnergy() {
        return this.minEnergy;
    }

    @Override
    public double getMinCapital() {
        return this.mingCapital;
    }

}
