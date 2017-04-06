package p01_logger;

import p01_logger.interfaces.Appender;
import p01_logger.interfaces.Logger;

public class Controller {
    private Logger logger;

    public Controller(Logger logger) {
        this.logger = logger;
    }

    public void info() {
        Appender[] appenders = this.logger.getAppenders();

        for (Appender appender : appenders) {
            System.out.println(appender.toString());
        }
    }
}
