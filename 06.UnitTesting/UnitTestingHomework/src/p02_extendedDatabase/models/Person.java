package p02_extendedDatabase.models;

import com.sun.deploy.perf.PerfRollup;

public class Person {
    private long id;
    private String name;

    public Person(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
