package p04_workForce.models.employees;

/**
 * Created by vladix on 4/19/17.
 */
public class PartTimeEmployee extends BaseEmployee {

    private static final int PART_TIME_EMPLOYEE_WORK_HOURS_PER_WEEK = 20;

    public PartTimeEmployee(String name) {
        super(name, PART_TIME_EMPLOYEE_WORK_HOURS_PER_WEEK);
    }
}
