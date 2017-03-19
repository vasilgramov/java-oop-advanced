package p06_genericCountMethodDoubles;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ComparableList<Double> comparableList = new ComparableList<>();

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            comparableList.add(Double.parseDouble(in.nextLine()));
        }

        System.out.println(comparableList.findBiggerThan(Double.parseDouble(in.nextLine())));
    }
}
