package p11_threeuple;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] firstLine = in.nextLine().split("\\s+");
        Threeuple<String, String, String> threeuple1 = new Threeuple<>(firstLine[0] + " " + firstLine[1], firstLine[2], firstLine[3]);
        System.out.println(threeuple1);

        String[] secondLine = in.nextLine().split("\\s+");
        boolean isDrunk = false;
        if (secondLine[2].equals("drunk")) {
            isDrunk = true;
        }
        Threeuple<String, Integer, Boolean> threeuple2 = new Threeuple<>(secondLine[0], Integer.parseInt(secondLine[1]), isDrunk);
        System.out.println(threeuple2);

        String[] thirdLine = in.nextLine().split("\\s+");
        Threeuple<String, Double, String> threeuple3 = new Threeuple<>(thirdLine[0], Double.parseDouble(thirdLine[1]), thirdLine[2]);
        System.out.println(threeuple3);
    }
}
