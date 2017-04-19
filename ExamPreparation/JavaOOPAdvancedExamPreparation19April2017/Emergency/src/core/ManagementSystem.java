package core;

import enums.EmergencyType;
import models.centers.Emergency;
import models.emergencies.Center;

/**
 * Created by vladix on 4/18/17.
 */
public interface ManagementSystem {

    String registerPropertyEmergency(Emergency emergency);

    String registerHealthEmergency(Emergency emergency);

    String registerOrderEmergency(Emergency emergency);

    String registerFireServiceCenter(Center center);

    String registerMedicalServiceCenter(Center center);

    String registerPoliceServiceCenter(Center center);

    String processEmergencies(EmergencyType emergencyType);

    String emergencyReport();

}
