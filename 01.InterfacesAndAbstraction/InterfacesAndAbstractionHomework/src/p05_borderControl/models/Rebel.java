package p05_borderControl.models;

import p05_borderControl.interfaces.Buyer;

public class Rebel implements Buyer {
    private String name;
    private int age;
    private String group;
    private int food;

    public Rebel(String name, int age, String group) {
        this.setName(name);
        this.setAge(age);
        this.setGroup(group);
    }

    @Override
    public int getFood() {
        return this.food;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getGroup() {
        return this.group;
    }

    private void setGroup(String group) {
        this.group = group;
    }

    @Override
    public void buyFood() {
        this.food += 5;
    }


}
