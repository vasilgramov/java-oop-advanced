package p08_petClinic.models;

import p08_petClinic.interfaces.Animal;

public class Pet implements Animal {
    private String name;
    private int age;
    private String kind;

    public Pet(String name, int age, String kind) {
        this.setName(name);
        this.setAge(age);
        this.setKind(kind);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getKind() {
        return this.kind;
    }

    private void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s", this.getName(), this.getAge(), this.getKind());
    }
}
