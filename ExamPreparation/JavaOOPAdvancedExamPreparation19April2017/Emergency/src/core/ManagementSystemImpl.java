package core;

import collection.EmergencyRegister;
import collection.EmergencyRegisterImpl;
import enums.CenterType;
import enums.EmergencyType;
import models.centers.Emergency;
import models.emergencies.Center;

import java.sql.BatchUpdateException;
import java.util.Deque;
import java.util.LinkedList;

public class ManagementSystemImpl implements ManagementSystem {

    private static final String PROCESSED_ALL_EMERGENCIES = "Successfully responded to all %s emergencies.";
    private static final String NOT_PROCESSED_ALL = "%s Emergencies left to process: %d.";

    private EmergencyRegister<Center> fireCenters;
    private EmergencyRegister<Center> medicalCenters;
    private EmergencyRegister<Center> policeCenters;

    private EmergencyRegister<Emergency> propertyEmergencies;
    private EmergencyRegister<Emergency> healthEmergencies;
    private EmergencyRegister<Emergency> orderEmergencies;

    private int processedEmergencies;

    private int amountOfTotalPropertyDamage;
    private int amountOfHealthCasualties;
    private int amountOfSpecialCases;

    private static final String REGISTERED_EMERGENCY = "Registered Public %s Emergency of level %s at %s.";
    private static final String REGISTER_CENTER = "Registered %s Service Emergency Center - %s.";

    public ManagementSystemImpl() {
        this.fireCenters = new EmergencyRegisterImpl<>();
        this.medicalCenters = new EmergencyRegisterImpl<>();
        this.policeCenters = new EmergencyRegisterImpl<>();

        this.propertyEmergencies = new EmergencyRegisterImpl<>();
        this.healthEmergencies = new EmergencyRegisterImpl<>();
        this.orderEmergencies = new EmergencyRegisterImpl<>();
    }

    @Override
    public String registerPropertyEmergency(Emergency emergency) {
        this.propertyEmergencies.enqueueEmergency(emergency);

        return String.format(REGISTERED_EMERGENCY,
                EmergencyType.PROPERTY, emergency.getEmergencyLevel(), emergency.getRegistrationTime());
    }

    @Override
    public String registerHealthEmergency(Emergency emergency) {
        this.healthEmergencies.enqueueEmergency(emergency);

        return String.format(REGISTERED_EMERGENCY,
                EmergencyType.HEALTH, emergency.getEmergencyLevel(), emergency.getRegistrationTime());
    }

    @Override
    public String registerOrderEmergency(Emergency emergency) {
        this.orderEmergencies.enqueueEmergency(emergency);

        return String.format(REGISTERED_EMERGENCY,
                EmergencyType.ORDER, emergency.getEmergencyLevel(), emergency.getRegistrationTime());
    }

    @Override
    public String registerFireServiceCenter(Center center) {
        this.fireCenters.enqueueEmergency(center);

        return String.format(REGISTER_CENTER, CenterType.FIRE, center.getName());
    }

    @Override
    public String registerMedicalServiceCenter(Center center) {
        this.medicalCenters.enqueueEmergency(center);

        return String.format(REGISTER_CENTER, CenterType.MEDICAL, center.getName());
    }

    @Override
    public String registerPoliceServiceCenter(Center center) {
        this.policeCenters.enqueueEmergency(center);

        return String.format(REGISTER_CENTER, CenterType.POLICE, center.getName());
    }

    @Override
    public String processEmergencies(EmergencyType emergencyType) {
        switch (emergencyType) {
            case HEALTH:
                return processHealthEmergencies();
            case ORDER:
                return processOrderEmergencies();
            case PROPERTY:
                return processPropertyEmergencies();
        }

        throw new IllegalArgumentException("Invalid Emergency type!");
    }

    @Override
    public String emergencyReport() {
        StringBuilder builder = new StringBuilder();
        builder.append("PRRM Services Live Statistics").append(System.lineSeparator())
                .append(String.format("Fire Service Centers: %d", this.fireCenters.size())).append(System.lineSeparator())
                .append(String.format("Medical Service Centers: %d", this.medicalCenters.size())).append(System.lineSeparator())
                .append(String.format("Police Service Centers: %d", this.policeCenters.size())).append(System.lineSeparator())
                .append(String.format("Total Processed Emergencies: %d", this.processedEmergencies)).append(System.lineSeparator())
                .append(String.format("Currently Registered Emergencies: %d", this.getCurrentRegisteredEmergencies())).append(System.lineSeparator())
                .append(String.format("Total Property Damage Fixed: %d", this.amountOfTotalPropertyDamage)).append(System.lineSeparator())
                .append(String.format("Total Health Casualties Saved: %d", this.amountOfHealthCasualties)).append(System.lineSeparator())
                .append(String.format("Total Special Cases Processed: %d", this.amountOfSpecialCases)).append(System.lineSeparator());

        return builder.toString();
    }

    private int getCurrentRegisteredEmergencies() {
        return this.healthEmergencies.size() + this.orderEmergencies.size() + this.propertyEmergencies.size();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////

    private String processPropertyEmergencies() {
        while (!this.fireCenters.isEmpty() && !this.propertyEmergencies.isEmpty()) {
            Center center = this.fireCenters.dequeueEmergency();

            Emergency emergency = this.propertyEmergencies.dequeueEmergency();
            this.amountOfTotalPropertyDamage += emergency.getData();

            center.processEmergency();
            if (!center.isForRetirement()) {
                this.fireCenters.enqueueEmergency(center);
            }

            this.processedEmergencies++;
        }

        if (this.propertyEmergencies.isEmpty()) {
            return String.format(PROCESSED_ALL_EMERGENCIES, EmergencyType.PROPERTY);
        } else {
            return String.format(NOT_PROCESSED_ALL, EmergencyType.PROPERTY, this.propertyEmergencies.size());
        }
    }

    private String processOrderEmergencies() {
        while (!this.policeCenters.isEmpty() && !this.orderEmergencies.isEmpty()) {
            Center center = this.policeCenters.dequeueEmergency();

            Emergency emergency = this.orderEmergencies.dequeueEmergency();
            Integer data = emergency.getData();
            this.amountOfSpecialCases = data == 0 ? this.amountOfSpecialCases : this.amountOfSpecialCases + 1;

            center.processEmergency();
            if (!center.isForRetirement()) {
                this.policeCenters.enqueueEmergency(center);
            }

            this.processedEmergencies++;
        }

        if (this.orderEmergencies.isEmpty()) {
            return String.format(PROCESSED_ALL_EMERGENCIES, EmergencyType.ORDER);
        } else {
            return String.format(NOT_PROCESSED_ALL, EmergencyType.ORDER, this.orderEmergencies.size());
        }
    }

    private String processHealthEmergencies() {
        while (!this.medicalCenters.isEmpty() && !this.healthEmergencies.isEmpty()) {
            Center center = this.medicalCenters.dequeueEmergency();

            Emergency emergency = this.healthEmergencies.dequeueEmergency();
            this.amountOfHealthCasualties += emergency.getData();

            center.processEmergency();
            if (!center.isForRetirement()) {
                this.medicalCenters.enqueueEmergency(center);
            }

            this.processedEmergencies++;
        }

        if (this.healthEmergencies.isEmpty()) {
            return String.format(PROCESSED_ALL_EMERGENCIES, EmergencyType.HEALTH);
        } else {
            return String.format(NOT_PROCESSED_ALL, EmergencyType.HEALTH, this.healthEmergencies.size());
        }
    }

}
