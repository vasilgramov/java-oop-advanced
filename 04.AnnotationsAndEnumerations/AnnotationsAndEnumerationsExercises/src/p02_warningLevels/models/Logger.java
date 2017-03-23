package p02_warningLevels.models;

import p02_warningLevels.enums.Importance;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private Importance lowerBoundary;
    private List<Message> messages;

    public Logger(Importance lowerBoundary) {
        this.setLowerBoundary(lowerBoundary);
        this.setMessages(new ArrayList<>());
    }

    public Importance getLowerBoundary() {
        return this.lowerBoundary;
    }

    private void setLowerBoundary(Importance lowerBoundary) {
        this.lowerBoundary = lowerBoundary;
    }

    public Iterable<Message> getMessages() {
        return this.messages;
    }

    private void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void record(Message message) {
        if (message.getLevel().compareTo(this.lowerBoundary) >= 0) {
            this.messages.add(message);
        }
    }
}
