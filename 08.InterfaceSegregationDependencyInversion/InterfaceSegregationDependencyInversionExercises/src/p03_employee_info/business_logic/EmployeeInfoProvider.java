package p03_employee_info.business_logic;

import p03_employee_info.data_access.EmployeeDatabase;
import p03_employee_info.models.Employee;
import p03_employee_info.presentation.InfoProvider;

import java.util.Comparator;
import java.util.stream.Collectors;

public class EmployeeInfoProvider implements InfoProvider {
    private Database database;

    public EmployeeInfoProvider() {
        this.database = new EmployeeDatabase();
    }

    @Override
    public Iterable<Employee> getBy(Comparator<Employee> comparator) {
        return this.database.readEmployees().stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
