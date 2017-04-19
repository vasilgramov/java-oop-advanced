package p04_workForce.models.jobs;


import p04_workForce.models.employees.Employee;

/**
 * Created by vladix on 4/19/17.
 */
public class JobImpl extends BaseJob {

    public JobImpl(String nameOfJob, int hoursOfWorkRequired, Employee employeeName) {
        super(nameOfJob, hoursOfWorkRequired, employeeName);
    }
}
