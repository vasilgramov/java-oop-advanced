package p03_employee_info.presentation;

import p03_employee_info.models.Employee;

import java.util.Comparator;

public class ConsoleClient {
    private Formatter formatter;
    private InfoProvider infoProvider;

    public ConsoleClient(Formatter formatter, InfoProvider infoProvider) {
        this.formatter = formatter;
        this.infoProvider = infoProvider;
    }

    public String run() {
        Iterable<Employee> employeesSortedByName = this.infoProvider.getBy(Comparator.comparing(Employee::getName));
        String formattedEmployees = this.formatter.format(employeesSortedByName);

        return formattedEmployees;
    }
}
