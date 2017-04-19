package models.centers;

import enums.EmergencyLevel;
import utils.RegistrationTime;
import utils.RegistrationTimeImpl;

/**
 * Created by vladix on 4/18/17.
 */
public class PropertyEmergency extends BaseEmergency {

    public PropertyEmergency(String description,
                             EmergencyLevel emergencyLevel,
                             RegistrationTime registrationTime,
                             String data) {
        super(description, emergencyLevel, registrationTime);
        this.setData(data);
    }


    @Override
    protected void setData(String data) {
        super.data = Integer.parseInt(data);
    }
}
