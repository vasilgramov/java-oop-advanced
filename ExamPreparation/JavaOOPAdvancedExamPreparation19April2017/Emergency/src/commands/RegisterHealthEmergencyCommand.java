package commands;

import core.ManagementSystem;
import enums.EmergencyLevel;
import models.centers.Emergency;
import models.centers.HealthEmergency;
import utils.RegistrationTime;
import utils.RegistrationTimeImpl;

/**
 * Created by vladix on 4/18/17.
 */
public class RegisterHealthEmergencyCommand extends BaseCommand {

    public RegisterHealthEmergencyCommand(ManagementSystem emergencyManagementSystem) {
        super(emergencyManagementSystem);
    }

    @Override
    public String execute(String[] tokens) {
        String description = tokens[1];
        EmergencyLevel emergencyLevel = EmergencyLevel.valueOf(tokens[2].toUpperCase());
        RegistrationTime registrationTime = new RegistrationTimeImpl(tokens[3]);
        String data = tokens[4];

        Emergency emergency = new HealthEmergency(description, emergencyLevel, registrationTime, data);
        return super.getEmergencyManagementSystem().registerHealthEmergency(emergency);
    }
}
