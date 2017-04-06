package p01_logger;

import p01_logger.enums.ReportLevel;
import p01_logger.interfaces.Appender;
import p01_logger.models.ConsoleAppender;
import p01_logger.models.FileAppender;

public class AppenderFactory {
    public static Appender createAppender(String[] appenderArgs) {
        Appender appender = null;

        String type = appenderArgs[0];
        String layoutType = appenderArgs[1];
        switch (type) {
            case "ConsoleAppender":
                appender = new ConsoleAppender(LayoutFactory.createLayout(layoutType));
                break;
            case "FileAppender":
                appender = new FileAppender(LayoutFactory.createLayout(layoutType));
                break;
        }

        if (appenderArgs.length == 3) {
            appender.setReportLevel(ReportLevel.valueOf(appenderArgs[2]));
        }

        return appender;
    }
}
