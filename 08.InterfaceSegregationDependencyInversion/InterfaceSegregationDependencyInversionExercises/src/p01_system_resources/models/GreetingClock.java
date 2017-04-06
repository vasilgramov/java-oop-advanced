package p01_system_resources.models;

import p01_system_resources.interfaces.TimeProvider;

import java.time.LocalTime;

public class GreetingClock {


    public GreetingClock() {

    }

    public String greeting(TimeProvider timeProvider) {
        LocalTime time = timeProvider.getTime();
        if (time.getHour() < 12) {
            return "Good morning...";
        } else if (time.getHour() < 18) {
            return "Good afternoon...";
        } else {
            return "Good evening...";
        }
    }
}
