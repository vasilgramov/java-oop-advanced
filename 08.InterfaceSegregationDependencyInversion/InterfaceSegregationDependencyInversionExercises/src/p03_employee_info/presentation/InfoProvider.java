package p03_employee_info.presentation;

import p03_employee_info.models.Employee;

import java.util.Comparator;

public interface InfoProvider {
    Iterable<Employee> getBy(Comparator<Employee> comparator);
}
