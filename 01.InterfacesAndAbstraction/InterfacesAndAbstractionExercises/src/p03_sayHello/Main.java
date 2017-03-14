package p03_sayHello;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Bulgarian("Pesho"));
        people.add(new European("George"));
        people.add(new Chinese("Shinzu"));

        for (Person person : people) {
            printPerson(person);
        }
    }

    private static void printPerson(Person person) {
        System.out.println(person.sayHello());
    }
}
