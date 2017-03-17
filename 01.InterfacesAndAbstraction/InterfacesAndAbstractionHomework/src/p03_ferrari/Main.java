package p03_ferrari;

import p03_ferrari.interfaces.Car;
import p03_ferrari.models.Ferrari;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String driver = in.nextLine();
        Car car = new Ferrari(driver);

        System.out.println(car);
    }
}
