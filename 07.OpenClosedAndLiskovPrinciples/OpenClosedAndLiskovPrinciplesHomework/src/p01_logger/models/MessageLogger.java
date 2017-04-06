package p01_logger.models;

import p01_logger.enums.ReportLevel;
import p01_logger.interfaces.Appender;
import p01_logger.interfaces.Logger;

public class MessageLogger implements Logger {
    private Appender[] appenders;


    public MessageLogger(Appender... appenders) {
        this.appenders = appenders;
    }

    public Appender[] getAppenders() {
        return this.appenders;
    }

    @Override
    public void logInfo(String date, String message) {
        for (Appender appender : appenders) {
            appender.append(date, ReportLevel.INFO, message);
        }
    }

    @Override
    public void logWarning(String date, String message) {
        for (Appender appender : appenders) {
            appender.append(date, ReportLevel.WARNING, message);
        }
    }

    @Override
    public void logError(String date, String message) {
        for (Appender appender : appenders) {
            appender.append(date, ReportLevel.ERROR, message);
        }
    }

    @Override
    public void logCritical(String date, String message) {
        for (Appender appender : appenders) {
            appender.append(date, ReportLevel.CRITICAL, message);
        }
    }

    @Override
    public void logFatal(String date, String message) {
        for (Appender appender : appenders) {
            appender.append(date, ReportLevel.FATAL, message);
        }
    }
}
