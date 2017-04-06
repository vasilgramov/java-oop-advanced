package p04_recharge.models;

import p04_recharge.interfaces.Sleeper;

public class Employee extends Worker implements Sleeper {

    public Employee(String id) {
        super(id);
    }

    public void sleep() {
        // sleep...
    }
}
