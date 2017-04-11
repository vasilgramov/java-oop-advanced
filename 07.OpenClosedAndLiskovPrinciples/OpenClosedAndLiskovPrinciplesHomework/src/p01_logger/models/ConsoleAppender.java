package p01_logger.models;

import p01_logger.enums.ReportLevel;
import p01_logger.interfaces.Appender;
import p01_logger.interfaces.Layout;

public class ConsoleAppender implements Appender {
    private static final String type = "ConsoleAppender";

    private Layout layout;
    private ReportLevel minReportLevel;
    private int messagesAppended;

    public ConsoleAppender(Layout layout) {
        this.layout = layout;
        this.minReportLevel = ReportLevel.INFO;
        this.messagesAppended = 0;
    }

    @Override
    public int getMessagesAppended() {
        return this.messagesAppended;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.minReportLevel = reportLevel;
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        if (reportLevel.ordinal() >= this.minReportLevel.ordinal()) {
            String formattedMessage = this.layout.formatMessage(date, reportLevel, message);

            this.messagesAppended++;
            System.out.println(formattedMessage);
        }
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                this.getType(), this.layout.getType(), this.minReportLevel.toString(), this.getMessagesAppended());
    }
}
