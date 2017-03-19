package p04_genericSwapIntegers;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        GenericList<Integer> genericList = new GenericList<>();

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            int element = Integer.parseInt(in.nextLine());
            genericList.add(element);
        }

        int[] indexes = stringsToIntegers(in.nextLine().split("\\s+"));
        int firstIndex = indexes[0];
        int secondIndex = indexes[1];

        genericList.swap(firstIndex, secondIndex);

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
