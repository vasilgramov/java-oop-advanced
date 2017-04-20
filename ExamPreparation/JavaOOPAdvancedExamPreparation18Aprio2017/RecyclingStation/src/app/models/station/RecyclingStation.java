package app.models.station;

import app.waste_disposal.contracts.ProcessingData;

/**
 * Created by vladix on 4/20/17.
 */
public interface RecyclingStation {

    double getEnergy();

    double getCapital();

    void processData(ProcessingData data);

    void setFilter(String[] filterData);

    String getFilter();

    double getMinEnergy();

    double getMinCapital();

}
