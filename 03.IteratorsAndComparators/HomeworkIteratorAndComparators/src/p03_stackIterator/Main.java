package p03_stackIterator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Stack<String> stack = new Stack<>();

        String command = in.nextLine();
        while (!"END".equals(command)) {
            if (command.equals("Pop")) {
                try {
                    stack.pop();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else if (command.startsWith("Push")) {
                String[] elements = command.substring(5).split(", ");
                for (String element : elements) {
                    stack.push(element);
                }
            }

            command = in.nextLine();
        }

        for (String s : stack) {
            System.out.println(s);
        }

        for (String s : stack) {
            System.out.println(s);
        }
    }
}
