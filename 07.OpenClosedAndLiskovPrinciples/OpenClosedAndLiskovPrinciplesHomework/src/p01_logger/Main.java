package p01_logger;

import p01_logger.enums.ReportLevel;
import p01_logger.interfaces.Appender;
import p01_logger.interfaces.Logger;
import p01_logger.models.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Layout simpleLayout = new SimpleLayout();
//        Appender consoleAppender = new ConsoleAppender(simpleLayout);
//
//        File file = new LogFile();
//        Appender fileAppender = new FileAppender(simpleLayout, file);
//
//        Logger logger = new MessageLogger(consoleAppender, fileAppender);
//
//        logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
//        logger.logError("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");
//
//        System.out.println(file.getMessages());

        //---------------------------------------------------------------------------
        //---------------------------------------------------------------------------
        //---------------------------------------------------------------------------

//        Layout xmlLayout = new XmlLayout();
//        Appender consoleAppender = new ConsoleAppender(xmlLayout);
//        Logger logger = new MessageLogger(consoleAppender);
//
//        logger.logFatal("3/31/2015 5:23:54 PM", "mscorlib.dll does not respond");
//        logger.logCritical("3/31/2015 5:23:54 PM", "No connection string found in App.config");


        //---------------------------------------------------------------------------
        //---------------------------------------------------------------------------
        //---------------------------------------------------------------------------


//        Layout simpleLayout = new SimpleLayout();
//        Appender consoleAppender = new ConsoleAppender(simpleLayout);
//        consoleAppender.setReportLevel(ReportLevel.ERROR);
//
//        Logger logger = new MessageLogger(consoleAppender);
//
//        logger.logInfo("3/31/2015 5:33:07 PM", "Everything seems fine");
//        logger.logWarning("3/31/2015 5:33:07 PM", "Warning: ping is too high - disconnect imminent");
//        logger.logError("3/31/2015 5:33:07 PM", "Error parsing request");
//        logger.logCritical("3/31/2015 5:33:07 PM", "No connection string found in App.config");
//        logger.logFatal("3/31/2015 5:33:07 PM", "mscorlib.dll does not respond");


        //---------------------------------------------------------------------------
        //---------------------------------------------------------------------------
        //---------------------------------------------------------------------------


        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        Appender[] appenders = new Appender[n];
        for (int i = 0; i < n; i++) {
            Appender appender = AppenderFactory.createAppender(in.nextLine().split("\\s+"));
            appenders[i] = appender;
        }

        Logger logger = new MessageLogger(appenders);

        String command = in.nextLine();
        while (!"END".equals(command)) {
            String[] commandArgs = command.split("\\|");
            ReportLevel reportLevel = ReportLevel.valueOf(commandArgs[0]);
            String date = commandArgs[1];
            String time = commandArgs[2];

            // INFO, WARNING, ERROR, CRITICAL, FATAL;
            switch (reportLevel) {
                case INFO:
                    logger.logInfo(date, time);
                    break;
                case WARNING:
                    logger.logWarning(date, time);
                    break;
                case ERROR:
                    logger.logError(date, time);
                    break;
                case CRITICAL:
                    logger.logCritical(date, time);
                    break;
                case FATAL:
                    logger.logFatal(date, time);
                    break;
            }

            command = in.nextLine();
        }

        Controller controller = new Controller(logger);
        controller.info();
    }
}
