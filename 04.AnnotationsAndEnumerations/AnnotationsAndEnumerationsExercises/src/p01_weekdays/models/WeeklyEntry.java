package p01_weekdays.models;

import p01_weekdays.enums.Weekday;

import java.util.Comparator;

public class WeeklyEntry {
    public final static Comparator<WeeklyEntry> BY_WEEKDAY = getWeekdayComparator();

    private Weekday weekday;
    private String notes;

    public WeeklyEntry(String weekday, String notes) {
        this.setWeekday(weekday);
        this.setNotes(notes);
    }

    public Weekday getWeekday() {
        return this.weekday;
    }

    private void setWeekday(String weekday) {
        this.weekday = Weekday.valueOf(Weekday.class, weekday.toUpperCase());
    }

    public String getNotes() {
        return this.notes;
    }

    private void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.getWeekday(), this.getNotes());
    }

    private static Comparator<WeeklyEntry> getWeekdayComparator() {
        return Comparator.comparingInt(e -> e.getWeekday().ordinal());
    }
}
