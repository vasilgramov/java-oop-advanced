package p05_genericCountMethodStrings;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ComparableList<String> comparableList = new ComparableList<>();

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            comparableList.add(in.nextLine());
        }

        String el = in.nextLine();

        System.out.println(comparableList.findBiggerThan(el));
    }
}
