package p04_detailPrinter;

public class DetailsPrinter {

    private Iterable<Employee> employees;

    public DetailsPrinter(Iterable<Employee> employees) {
        this.employees = employees;
    }

    public void printDetails() {
        for (Employee employee : this.employees) {
            System.out.println(employee);
        }
    }
}
