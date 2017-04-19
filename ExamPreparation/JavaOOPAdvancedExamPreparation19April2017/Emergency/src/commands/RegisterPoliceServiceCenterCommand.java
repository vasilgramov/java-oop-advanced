package commands;

import core.ManagementSystem;
import models.emergencies.Center;
import models.emergencies.PoliceServiceCenter;

/**
 * Created by vladix on 4/18/17.
 */
public class RegisterPoliceServiceCenterCommand extends BaseCommand {


    public RegisterPoliceServiceCenterCommand(ManagementSystem emergencyManagementSystem) {
        super(emergencyManagementSystem);
    }

    @Override
    public String execute(String[] tokens) {
        String name = tokens[1];
        int amountOfEmergencies = Integer.parseInt(tokens[2]);

        Center center = new PoliceServiceCenter(name, amountOfEmergencies);
        return super.getEmergencyManagementSystem().registerPoliceServiceCenter(center);
    }
}
