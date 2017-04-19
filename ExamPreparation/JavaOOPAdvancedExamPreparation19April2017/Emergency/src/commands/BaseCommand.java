package commands;

import core.ManagementSystem;

/**
 * Created by vladix on 4/18/17.
 */
public abstract class BaseCommand implements Executable {

    private ManagementSystem emergencyManagementSystem;

    protected BaseCommand(ManagementSystem emergencyManagementSystem) {
        this.emergencyManagementSystem = emergencyManagementSystem;
    }

    protected ManagementSystem getEmergencyManagementSystem() {
        return this.emergencyManagementSystem;
    }
}
