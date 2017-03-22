package p05_comparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Human> people = new ArrayList<>();
        String command = in.nextLine();
        while (!"END".equals(command)) {
            String[] personArgs = command.split("\\s+");
            String name = personArgs[0];
            int age = Integer.parseInt(personArgs[1]);
            String town = personArgs[2];

            Human person = new Person(name, age, town);
            people.add(person);

            command = in.nextLine();
        }

        int n = Integer.parseInt(in.nextLine()) - 1;
        Human personToCompare = people.get(n);

        int numberOfEqualPeople = 0;
        int numberOfNotEqualPeople = 0;
        int totalNumberOfPeople = people.size();
        for (Human person : people) {
            if (personToCompare.compareTo(person) == 0) {
                numberOfEqualPeople++;
            }
        }

        numberOfNotEqualPeople = totalNumberOfPeople - numberOfEqualPeople;

        if (numberOfEqualPeople == 1) {
            System.out.println("No matches");
        } else {
            System.out.println(String.format("%d %d %d", numberOfEqualPeople, numberOfNotEqualPeople, totalNumberOfPeople));
        }
    }
}
