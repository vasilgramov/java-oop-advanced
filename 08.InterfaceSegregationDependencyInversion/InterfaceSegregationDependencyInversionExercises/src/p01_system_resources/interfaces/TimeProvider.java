package p01_system_resources.interfaces;

import java.time.LocalTime;

public interface TimeProvider {
    LocalTime getTime();
}
