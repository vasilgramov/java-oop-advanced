package p04_telephony.models;

import p04_telephony.interfaces.Browseable;
import p04_telephony.interfaces.Callable;

public class Smartphone implements Callable, Browseable{

    public Smartphone() {
    }

    @Override
    public void call(String number) {
        if (!isValidNumber(number)) {
            throw new IllegalArgumentException("Invalid number!");
        }

        System.out.println("Calling... " + number);
    }

    @Override
    public void browse(String website) {
        if (!isValidWebsite(website)) {
            throw new IllegalArgumentException("Invalid URL!");
        }

        System.out.println("Browsing: " + website + "!");
    }

    private boolean isValidNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (Character.isAlphabetic(number.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidWebsite(String website) {
        for (int i = 0; i < website.length(); i++) {
            if (Character.isDigit(website.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
