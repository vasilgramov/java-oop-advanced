package p01_weekdays.enums;

public enum Weekday {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    @Override
    public String toString() {
        String result = "";
        result += super.name().charAt(0);
        result += super.name().substring(1).toLowerCase();

        return result;
    }
}
