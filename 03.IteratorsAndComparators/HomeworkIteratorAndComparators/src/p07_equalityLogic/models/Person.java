package p07_equalityLogic.models;


import p07_equalityLogic.interfaces.Human;

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

//    @Override
//    public int compareTo(Human o) {
//        String other = o.getName() + o.getName();
//        return (this.getName() + this.getAge()).compareTo(other);
//    }

    @Override
    public int hashCode() {
        return (this.getName() + " " + this.getAge()).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Human other = (Human) obj;
        return this.compareTo(other) == 0;
    }

    @Override
    public int compareTo(Human o) {
        String other = o.getName() + o.getAge();
        return (this.getName() + this.getAge()).compareTo(other);
    }
}
