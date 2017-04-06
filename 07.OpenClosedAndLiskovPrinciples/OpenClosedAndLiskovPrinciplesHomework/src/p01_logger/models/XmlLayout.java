package p01_logger.models;

import p01_logger.enums.ReportLevel;
import p01_logger.interfaces.Layout;

public class XmlLayout implements Layout {
    private static final String type = "XmlLayout";

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String formatMessage(String date, ReportLevel reportLevel, String message) {
        StringBuilder builder = new StringBuilder();
        builder.append("<log>").append(System.lineSeparator())
                .append("   <date>").append(date).append("</date>").append(System.lineSeparator())
                .append("   <level>").append(reportLevel.toString()).append("</level>").append(System.lineSeparator())
                .append("   <message>").append(message).append("</message>").append(System.lineSeparator())
                .append("</log>");

        return builder.toString();
    }
}
