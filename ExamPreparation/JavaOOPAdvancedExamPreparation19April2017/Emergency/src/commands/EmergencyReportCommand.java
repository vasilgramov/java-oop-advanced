package commands;

import core.ManagementSystem;

/**
 * Created by vladix on 4/19/17.
 */
public class EmergencyReportCommand extends BaseCommand {

    public EmergencyReportCommand(ManagementSystem emergencyManagementSystem) {
        super(emergencyManagementSystem);
    }

    @Override
    public String execute(String[] tokens) {
        return super.getEmergencyManagementSystem().emergencyReport();
    }
}
