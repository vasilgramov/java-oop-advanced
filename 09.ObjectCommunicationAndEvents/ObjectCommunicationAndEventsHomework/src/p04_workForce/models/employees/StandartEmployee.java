package p04_workForce.models.employees;

/**
 * Created by vladix on 4/19/17.
 */
public class StandartEmployee extends BaseEmployee {

    private static final int STANDART_EMPLOYEE_WORK_HOURS_PER_WEEK = 40;

    public StandartEmployee(String name) {
        super(name, STANDART_EMPLOYEE_WORK_HOURS_PER_WEEK);
    }
}
