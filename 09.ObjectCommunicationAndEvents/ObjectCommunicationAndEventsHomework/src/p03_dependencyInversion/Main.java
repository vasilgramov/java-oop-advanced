package p03_dependencyInversion;

import p03_dependencyInversion.calculator.Calculator;
import p03_dependencyInversion.calculator.PrimitiveCalculator;

import java.util.Scanner;

/**
 * Created by vladix on 4/12/17.
 */
public class Main {

    public static void main(String[] args) {

        PrimitiveCalculator calculator = new PrimitiveCalculator();

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");
            if (tokens[0].equals("mode")) {
                calculator.changeStrategy(tokens[1].charAt(0));
            } else {
                calculator.performCalculation(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
            }

            line = in.nextLine();
        }

    }
}
