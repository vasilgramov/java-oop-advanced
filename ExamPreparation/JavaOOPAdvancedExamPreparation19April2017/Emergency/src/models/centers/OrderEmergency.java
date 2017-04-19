package models.centers;

import enums.EmergencyLevel;
import enums.Status;
import utils.RegistrationTime;
import utils.RegistrationTimeImpl;

/**
 * Created by vladix on 4/18/17.
 */
public class OrderEmergency extends BaseEmergency {


    public OrderEmergency(String description,
                             EmergencyLevel emergencyLevel,
                          RegistrationTime registrationTime,
                             String data) {
        super(description, emergencyLevel, registrationTime);
        this.setData(data);
    }

    @Override
    protected void setData(String data) {
        if (data.contains("-")) {
            data = data.replace("-", "_");
        }

        Status status = Status.valueOf(data.toUpperCase());

        switch (status) {
            case NON_SPECIAL:
                super.data = 0;
                break;
            case SPECIAL:
                super.data = 1;
                break;
        }
    }
}
