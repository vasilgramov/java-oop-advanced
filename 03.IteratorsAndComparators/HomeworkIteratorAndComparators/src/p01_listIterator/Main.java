package p01_listIterator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ListyIterator<String> listyIterator = new ListyIterator<>();

        String command = in.nextLine();
        while (!"END".equals(command)) {
            if (command.startsWith("Create")) {
                try {
                    String[] elements = command.substring(7).split("\\s+");
                    listyIterator = new ListyIterator(elements);
                } catch (Exception e) {
                }
            } else if (command.equals("HasNext")) {
                System.out.println(listyIterator.hasNext());
            } else if (command.equals("Move")) {
                System.out.println(listyIterator.move());
            } else if (command.equals("Print")) {
                try {
                    listyIterator.print();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else if (command.equals("PrintAll")) {
                for (String element : listyIterator) {
                    System.out.print(element + " ");
                }

                System.out.println();
            }

            command = in.nextLine();
        }
    }
}
