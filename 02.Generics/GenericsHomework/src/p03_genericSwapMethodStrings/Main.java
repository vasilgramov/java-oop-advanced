package p03_genericSwapMethodStrings;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        GenericList<String> genericList = new GenericList<>();

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String element = in.nextLine();

            genericList.add(element);
        }

        int[] indexes = stringsToIntegers(in.nextLine().split("\\s+"));
        int startIndex = indexes[0];
        int endIndex = indexes[1];

        genericList.swap(startIndex, endIndex);

        System.out.println(genericList);
    }

    private static int[] stringsToIntegers(String[] numbersAsString) {
        int[] parsedNumbers = new int[numbersAsString.length];

        for (int i = 0; i < numbersAsString.length; i++) {
            parsedNumbers[i] = Integer.parseInt(numbersAsString[i]);
        }


        return parsedNumbers;
    }
}
