package models.centers;

import enums.EmergencyLevel;
import utils.RegistrationTime;
import utils.RegistrationTimeImpl;

public abstract class BaseEmergency implements Emergency {

    private String description;

    private EmergencyLevel emergencyLevel;

    private RegistrationTime registrationTime;

    protected Integer data;

    protected BaseEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime) {
        this.setDescription(description);
        this.setEmergencyLevel(emergencyLevel);
        this.setRegistrationTime(registrationTime);

    }

    @Override
    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    @Override
    public EmergencyLevel getEmergencyLevel() {
        return emergencyLevel;
    }

    private void setEmergencyLevel(EmergencyLevel emergencyLevel) {
        this.emergencyLevel = emergencyLevel;
    }

    @Override
    public RegistrationTime getRegistrationTime() {
        return registrationTime;
    }

    private void setRegistrationTime(RegistrationTime registrationTime) {
        this.registrationTime = registrationTime;
    }

    @Override
    public Integer getData() {
        return this.data;
    }

    protected abstract void setData(String data);
}
