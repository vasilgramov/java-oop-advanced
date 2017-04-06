package p03_employee_info;


import p03_employee_info.business_logic.ConsoleFormatter;
import p03_employee_info.business_logic.EmployeeInfoProvider;
import p03_employee_info.presentation.ConsoleClient;
import p03_employee_info.presentation.Formatter;
import p03_employee_info.presentation.InfoProvider;

public class Main {

    public static void main(String[] args) {
        Formatter consoleFormatter = new ConsoleFormatter();
        InfoProvider employeeInfoProvider = new EmployeeInfoProvider();
        ConsoleClient consoleClient = new ConsoleClient(consoleFormatter, employeeInfoProvider);

        System.out.println(consoleClient.run());
    }
}
