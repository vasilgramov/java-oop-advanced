package p01_logger.interfaces;

import p01_logger.enums.ReportLevel;

public interface Layout {
    String getType();

    String formatMessage(String date, ReportLevel reportLevel, String message);
}
