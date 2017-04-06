package p01_logger.interfaces;

import p01_logger.enums.ReportLevel;

public interface Appender {
    int getMessagesAppended();

    String getType();

    void setReportLevel(ReportLevel reportLevel);

    void append(String date, ReportLevel reportLevel, String message);
}
