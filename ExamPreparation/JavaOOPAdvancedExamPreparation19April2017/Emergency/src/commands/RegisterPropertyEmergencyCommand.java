package commands;

import core.ManagementSystem;
import enums.EmergencyLevel;
import models.centers.Emergency;
import models.centers.PropertyEmergency;
import utils.RegistrationTime;
import utils.RegistrationTimeImpl;

/**
 * Created by vladix on 4/18/17.
 */
public class RegisterPropertyEmergencyCommand extends BaseCommand {

    public RegisterPropertyEmergencyCommand(ManagementSystem emergencyManagementSystem) {
        super(emergencyManagementSystem);
    }

    @Override
    public String execute(String[] tokens) {
        String description = tokens[1];
        EmergencyLevel emergencyLevel = EmergencyLevel.valueOf(tokens[2].toUpperCase());
        RegistrationTime registrationTime = new RegistrationTimeImpl(tokens[3]);
        String data = tokens[4];

        Emergency emergency = new PropertyEmergency(description, emergencyLevel, registrationTime, data);

        return super.getEmergencyManagementSystem().registerPropertyEmergency(emergency);
    }
}
