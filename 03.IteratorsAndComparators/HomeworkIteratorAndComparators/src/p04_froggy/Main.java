package p04_froggy;

import p04_froggy.models.Lake;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String command = in.nextLine();
        while (!"END".equals(command)) {
            Lake<Integer> lake = new Lake<>();
            int[] nums = stringsToIntegers(command.split(", | |,"));

            for (int num : nums) {
                lake.addElement(num);
            }

            StringBuilder builder = new StringBuilder();
            for (Integer integer : lake) {
                builder.append(integer + ", ");
            }

            System.out.println(builder.substring(0, builder.length() - 2));

            command = in.nextLine();
        }
    }

    private static int[] stringsToIntegers(String[] numbersAsString) {
        int[] parsedNumbers = new int[numbersAsString.length];

        for (int i = 0; i < numbersAsString.length; i++) {
            parsedNumbers[i] = Integer.parseInt(numbersAsString[i]);
        }


        return parsedNumbers;
    }
}
