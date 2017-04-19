package commands;

import core.ManagementSystem;
import enums.EmergencyType;

/**
 * Created by vladix on 4/19/17.
 */
public class ProcessEmergenciesCommand extends BaseCommand {


    public ProcessEmergenciesCommand(ManagementSystem emergencyManagementSystem) {
        super(emergencyManagementSystem);
    }

    @Override
    public String execute(String[] tokens) {
        EmergencyType emergencyType = EmergencyType.valueOf(tokens[1].toUpperCase());
        return super.getEmergencyManagementSystem().processEmergencies(emergencyType);
    }
}
