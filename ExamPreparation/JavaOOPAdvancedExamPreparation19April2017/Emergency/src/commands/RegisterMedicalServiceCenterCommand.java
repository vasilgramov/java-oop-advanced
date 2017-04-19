package commands;

import core.ManagementSystem;
import models.emergencies.Center;
import models.emergencies.MedicalServiceCenter;

/**
 * Created by vladix on 4/18/17.
 */
public class RegisterMedicalServiceCenterCommand extends BaseCommand {


    public RegisterMedicalServiceCenterCommand(ManagementSystem emergencyManagementSystem) {
        super(emergencyManagementSystem);
    }

    @Override
    public String execute(String[] tokens) {
        String name = tokens[1];
        int amountOfEmergencies = Integer.parseInt(tokens[2]);

        Center center = new MedicalServiceCenter(name, amountOfEmergencies);
        return super.getEmergencyManagementSystem().registerMedicalServiceCenter(center);
    }
}
