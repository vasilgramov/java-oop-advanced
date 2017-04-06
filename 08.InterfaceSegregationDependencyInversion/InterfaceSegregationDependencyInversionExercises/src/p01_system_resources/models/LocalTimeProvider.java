package p01_system_resources.models;

import p01_system_resources.interfaces.TimeProvider;

import java.time.LocalTime;

public class LocalTimeProvider implements TimeProvider {
    @Override
    public LocalTime getTime() {
        return LocalTime.now();
    }
}
