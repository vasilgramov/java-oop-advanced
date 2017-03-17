package p04_telephony;

import p04_telephony.models.Smartphone;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Smartphone smartphone = new Smartphone();

        String[] numbers = in.nextLine().split("\\s+");
        for (String number : numbers) {
            try {
                smartphone.call(number);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String[] websites = in.nextLine().split("\\s+");
        for (String website : websites) {
            try  {
                smartphone.browse(website);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
