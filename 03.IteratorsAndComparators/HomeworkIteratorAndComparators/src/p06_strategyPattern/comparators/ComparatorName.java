package p06_strategyPattern.comparators;

import p06_strategyPattern.interfaces.Human;

import java.util.Comparator;

public class ComparatorName implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        if (h1.getName().length() == h2.getName().length()) {
            return Character.compare(h1.getName().toLowerCase().charAt(0), h2.getName().toLowerCase().charAt(0));
        }

        return Integer.compare(h1.getName().length(), h2.getName().length());
    }
}
