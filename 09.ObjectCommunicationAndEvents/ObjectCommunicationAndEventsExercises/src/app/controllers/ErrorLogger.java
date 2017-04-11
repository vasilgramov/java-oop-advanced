package app.controllers;

import app.enums.LogType;

public class ErrorLogger implements Handler {
    private Handler successor;

    @Override
    public void handle(LogType logType, String message) {
        if (logType == LogType.ERROR) {
            System.out.println(logType + " " + message);
        } else {
            if (this.successor != null) {
                this.successor.handle(logType, message);
            }
        }
    }

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}
