package p01_weekdays.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeeklyCalendar {
    private List<WeeklyEntry> weeklyEntry;

    public WeeklyCalendar() {
        this.weeklyEntry = new ArrayList<>();
    }

    public Iterable<WeeklyEntry> getWeeklySchedule() {
        Collections.sort(this.weeklyEntry, WeeklyEntry.BY_WEEKDAY);

        return this.weeklyEntry;
    }

    public void addEntry(String weekday, String notes) {
        this.weeklyEntry.add(new WeeklyEntry(weekday, notes));
    }
}
