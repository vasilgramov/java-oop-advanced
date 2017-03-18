package p08_militaryElite.models;

import p08_militaryElite.interfaces.Repair;

public class RepairImpl implements Repair {
    private String partName;
    private int hoursWorked;

    public RepairImpl(String partName, int hoursWorked) {
        this.setPartName(partName);
        this.setHoursWorked(hoursWorked);
    }

    @Override
    public String getPartName() {
        return this.partName;
    }

    private void setPartName(String partName) {
        this.partName = partName;
    }

    @Override
    public int getHoursWorked() {
        return this.hoursWorked;
    }

    private void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d", this.getPartName(), this.getHoursWorked());
    }
}
