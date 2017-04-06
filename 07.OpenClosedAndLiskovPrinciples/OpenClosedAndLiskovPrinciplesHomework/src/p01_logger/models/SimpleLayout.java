package p01_logger.models;

import p01_logger.enums.ReportLevel;
import p01_logger.interfaces.Layout;

public class SimpleLayout implements Layout {
    private static final String type = "SimpleLayout";

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String formatMessage(String date, ReportLevel reportLevel, String message) {
        return String.format("%s - %s - %s", date, reportLevel.toString(), message);
    }
}
