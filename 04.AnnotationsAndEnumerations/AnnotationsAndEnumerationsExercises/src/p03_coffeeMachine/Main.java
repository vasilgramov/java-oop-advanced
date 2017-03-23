package p03_coffeeMachine;

import p03_coffeeMachine.models.Coffee;
import p03_coffeeMachine.models.CoffeeMachine;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        String command = in.nextLine();
        while (!"END".equals(command)) {
            String[] commandArgs = command.split("\\s+");
            if (commandArgs.length == 1) { // coin
                coffeeMachine.insertCoin(commandArgs[0]);
            } else {
                coffeeMachine.buyCoffee(commandArgs[0], commandArgs[1]);
            }

            command = in.nextLine();
        }

        for (Coffee coffee : coffeeMachine.coffeesSold()) {
            System.out.println(coffee);
        }
    }
}
