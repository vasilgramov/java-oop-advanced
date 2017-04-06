package p03_employee_info.business_logic;

import p03_employee_info.presentation.Formatter;

public class ConsoleFormatter implements Formatter {

    @Override
    public String format(Iterable<?> iterable) {
        StringBuilder sb = new StringBuilder();
        for (Object o : iterable) {
            sb.append(o).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
