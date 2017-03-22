package p06_strategyPattern;

import p06_strategyPattern.comparators.ComparatorAge;
import p06_strategyPattern.comparators.ComparatorName;
import p06_strategyPattern.interfaces.Human;
import p06_strategyPattern.models.Person;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Set<Human> sortedByNames = new TreeSet<>(new ComparatorName());
        Set<Human> sortedByAge = new TreeSet<>(new ComparatorAge());

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] personArgs = in.nextLine().split("\\s+");
            String name = personArgs[0];
            int age = Integer.parseInt(personArgs[1]);

            Human person = new Person(name, age);

            sortedByNames.add(person);
            sortedByAge.add(person);
        }

        for (Human sortedByName : sortedByNames) {
            System.out.println(sortedByName);
        }

        for (Human human : sortedByAge) {
            System.out.println(human);
        }
    }
}
