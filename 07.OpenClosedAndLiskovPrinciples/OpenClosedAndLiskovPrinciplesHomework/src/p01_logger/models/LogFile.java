package p01_logger.models;

import p01_logger.interfaces.File;

public class LogFile implements File {
    private StringBuilder messages;
    private int size;

    public LogFile() {
        this.messages = new StringBuilder();
        this.size = 0;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public StringBuilder getMessages() {
        return messages;
    }

    public void write(String message) {
        this.messages.append(message).append(System.lineSeparator());

        for (int i = 0; i < message.length(); i++) {
            if (Character.isAlphabetic(message.charAt(i))) {
                this.size += message.charAt(i);
            }
        }
    }
}
