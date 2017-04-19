package commands;

import core.ManagementSystem;
import enums.EmergencyLevel;
import models.centers.Emergency;
import models.centers.OrderEmergency;
import utils.RegistrationTime;
import utils.RegistrationTimeImpl;

/**
 * Created by vladix on 4/18/17.
 */
public class RegisterOrderEmergencyCommand extends BaseCommand {


    public RegisterOrderEmergencyCommand(ManagementSystem emergencyManagementSystem) {
        super(emergencyManagementSystem);
    }

    @Override
    public String execute(String[] tokens) {
        String description = tokens[1];
        EmergencyLevel emergencyLevel = EmergencyLevel.valueOf(tokens[2].toUpperCase());
        RegistrationTime registrationTime = new RegistrationTimeImpl(tokens[3]);
        String data = tokens[4];

        Emergency emergency = new OrderEmergency(description, emergencyLevel, registrationTime, data);
        return super.getEmergencyManagementSystem().registerOrderEmergency(emergency);
    }
}
