package p03_scale;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scale<String> stringScale = new Scale<>("Ani", "Vasko");
        String heavierStr = stringScale.getHeavier();
        System.out.println(heavierStr);

        Scale<Integer> integerScale = new Scale<>(1, 5);
        int heavierInt = integerScale.getHeavier();
        System.out.println(heavierInt);
    }
}
