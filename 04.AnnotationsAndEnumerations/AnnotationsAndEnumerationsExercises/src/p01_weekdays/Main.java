package p01_weekdays;

import p01_weekdays.models.WeeklyCalendar;
import p01_weekdays.models.WeeklyEntry;


public class Main {

    public static void main(String[] args) {
        WeeklyCalendar weeklyCalendar = new WeeklyCalendar();

        weeklyCalendar.addEntry("Friday", "Programming");
        weeklyCalendar.addEntry("Saturday", "Table tennis");

        Iterable<WeeklyEntry> schedule = weeklyCalendar.getWeeklySchedule();
        for (WeeklyEntry weeklyEntry : schedule) {
            System.out.println(weeklyEntry);
        }

    }
}
