package p02_warningLevels.models;

import p02_warningLevels.enums.Importance;

public class Message {
    private Importance level;
    private String content;

    public Message(Importance level, String content) {
        this.level = level;
        this.content = content;
    }

    public Importance getLevel() {
        return this.level;
    }

    private void setLevel(Importance level) {
        this.level = level;
    }

    public String getContent() {
        return this.content;
    }

    private void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.getLevel(), this.getContent());
    }
}
