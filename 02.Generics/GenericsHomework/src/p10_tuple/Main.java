package p10_tuple;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        String[] firstLine = in.nextLine().split("\\s+");
        Tuple<String, String> tuple1 = new Tuple<>(firstLine[0] + " " + firstLine[1], firstLine[2]);
        System.out.println(tuple1);

        String[] secondLine = in.nextLine().split("\\s+");
        Tuple<String, Integer> tuple2 = new Tuple<>(secondLine[0], Integer.parseInt(secondLine[1]));
        System.out.println(tuple2);

        String[] thirdLine = in.nextLine().split("\\s+");
        Tuple<Integer, Double> tuple3 = new Tuple<>(Integer.parseInt(thirdLine[0]), Double.parseDouble(thirdLine[1]));
        System.out.println(tuple3);
    }
}
