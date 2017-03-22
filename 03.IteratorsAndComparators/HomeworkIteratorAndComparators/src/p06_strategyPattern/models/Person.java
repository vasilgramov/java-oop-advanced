package p06_strategyPattern.models;


import p06_strategyPattern.interfaces.Human;

public class Person implements Human {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
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
    public String toString() {
        return String.format("%s %d", this.getName(), this.getAge());
    }
}
