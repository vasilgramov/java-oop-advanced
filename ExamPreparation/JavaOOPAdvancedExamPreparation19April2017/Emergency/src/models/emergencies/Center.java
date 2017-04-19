package models.emergencies;

/**
 * Created by vladix on 4/18/17.
 */
public interface Center {

    String getName();

    Integer getAmountOfMaximumEmergencies();

    Boolean isForRetirement();

    void processEmergency();

}
