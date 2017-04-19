package p04_workForce.models.jobs;

import p04_workForce.models.employees.Employee;

/**
 * Created by vladix on 4/19/17.
 */
public abstract class BaseJob implements Job {

    private String nameOfJob;
    private int hoursOfWorkRequired;
    private Employee employee;

    protected BaseJob(String nameOfJob, int hoursOfWorkRequired, Employee employee) {
        this.nameOfJob = nameOfJob;
        this.hoursOfWorkRequired = hoursOfWorkRequired;
        this.employee = employee;
    }

    @Override
    public String getNameOfJob() {
        return this.nameOfJob;
    }

    @Override
    public int getHoursOfWorkRequired() {
        return this.hoursOfWorkRequired;
    }

    @Override
    public void update() {
        this.hoursOfWorkRequired -= this.employee.getWorkHoursPerWeek();
    }

}
