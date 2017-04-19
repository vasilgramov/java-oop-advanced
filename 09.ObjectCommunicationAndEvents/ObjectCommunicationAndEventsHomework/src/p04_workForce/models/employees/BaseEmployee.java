package p04_workForce.models.employees;

/**
 * Created by vladix on 4/19/17.
 */
public abstract class BaseEmployee implements Employee {

    private String name;
    private int workHoursPerWeek;

    protected BaseEmployee(String name, int workHoursPerWeek) {
        this.name = name;
        this.workHoursPerWeek = workHoursPerWeek;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getWorkHoursPerWeek() {
        return this.workHoursPerWeek;
    }
}
