package p01_logger.models;

import p01_logger.enums.ReportLevel;
import p01_logger.interfaces.Appender;
import p01_logger.interfaces.File;
import p01_logger.interfaces.Layout;

public class FileAppender implements Appender {
    private static final String type = "FileAppender";

    private Layout layout;
    private File file;
    private ReportLevel minReportLevel;
    private int messagesAppended;

    public FileAppender(Layout layout) {
        this.layout = layout;
        this.file = new LogFile();
        this.minReportLevel = ReportLevel.INFO;
        this.messagesAppended = 0;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getMessagesAppended() {
        return this.messagesAppended;
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
            this.file.write(formattedMessage);
        }
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s,  Report level: %s, Messages appended: %d, File size: %d",
                this.getType(), this.layout.getType(), this.minReportLevel.toString(), this.getMessagesAppended(), this.file.getSize());
    }
}
