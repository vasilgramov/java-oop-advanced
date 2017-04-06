package p01_system_resources;

import p01_system_resources.interfaces.TimeProvider;
import p01_system_resources.models.GreetingClock;
import p01_system_resources.models.LocalTimeProvider;

public class Main {

    public static void main(String[] args) {
        GreetingClock greetingClock = new GreetingClock();
        TimeProvider timeProvider = new LocalTimeProvider();
        String greeting = greetingClock.greeting(timeProvider);

        System.out.println(greeting);
    }
}
