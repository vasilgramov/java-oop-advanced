package p05_comparingObjects;

public class Person implements Human {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.setName(name);
        this.setAge(age);
        this.setTown(town);
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

    @Override
    public String getTown() {
        return this.town;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setTown(String town) {
        this.town = town;
    }

    @Override
    public int compareTo(Human other) {
        if (this.getName().equals(other.getName())) {
            if (this.getAge() == other.getAge()) {
                return this.getTown().compareTo(other.getTown());
            }

            return Integer.compare(this.getAge(), other.getAge());
        }

        return this.getName().compareTo(other.getName());
    }
}
