package p07_equalityLogic;

import p07_equalityLogic.interfaces.Human;
import p07_equalityLogic.models.Person;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Set<Human> hashSet = new HashSet<>();
        Set<Human> treeSet = new TreeSet<>();

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] personArgs = in.nextLine().split("\\s+");
            String name = personArgs[0];
            int age = Integer.parseInt(personArgs[1]);

            Human person = new Person(name, age);
            hashSet.add(person);
            treeSet.add(person);
        }

        System.out.println(hashSet.size());
        System.out.println(treeSet.size());
    }
}
