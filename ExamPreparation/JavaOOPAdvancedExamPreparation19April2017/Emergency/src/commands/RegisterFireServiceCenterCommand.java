package commands;

import core.ManagementSystem;
import models.emergencies.Center;
import models.emergencies.FireServiceCenter;

/**
 * Created by vladix on 4/18/17.
 */
public class RegisterFireServiceCenterCommand extends BaseCommand {

    public RegisterFireServiceCenterCommand(ManagementSystem emergencyManagementSystem) {
        super(emergencyManagementSystem);
    }

    @Override
    public String execute(String[] tokens) {
        String name = tokens[1];
        int amountOfEmergencies = Integer.parseInt(tokens[2]);

        Center center = new FireServiceCenter(name, amountOfEmergencies);
        return super.getEmergencyManagementSystem().registerFireServiceCenter(center);
    }
}
