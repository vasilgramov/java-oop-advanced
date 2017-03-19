package p02_genericBoxOfIntegers;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(in.nextLine());
            Box<Integer> box = new Box<>(value);

            System.out.println(box);
        }
    }
}
