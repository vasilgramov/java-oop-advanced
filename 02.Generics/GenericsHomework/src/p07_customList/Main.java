package p07_customList;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        CustomList<String> customList = new CustomList<>();

        String command = "";
        while (!"END".equals(command = in.nextLine())) {
            String[] commandArgs = command.split("\\s+");
            String commandType = commandArgs[0];

            if (commandType.equals("Add")) {
                customList.add(commandArgs[1]);
            } else if (commandType.equals("Remove")) {
                customList.remove(Integer.parseInt(commandArgs[1]));
            } else if (commandType.equals("Contains")) {
                System.out.println(customList.contains(commandArgs[1]));
            } else if (commandType.equals("Swap")) {
                customList.swap(Integer.parseInt(commandArgs[1]), Integer.parseInt(commandArgs[2]));
            } else if (commandType.equals("Greater")) {
                System.out.println(customList.countGreaterThan(commandArgs[1]));
            } else if (commandType.equals("Max")) {
                System.out.println(customList.getMax());
            } else if (commandType.equals("Min")) {
                System.out.println(customList.getMin());
            } else if (commandType.equals("Print")) {
                for (String o : customList) {
                    System.out.println(o);
                }
            } else if (commandType.equals("Sort")) {
                customList.sort();
            }
        }
    }
}
