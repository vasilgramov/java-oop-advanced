package p06_strategyPattern.comparators;


import p06_strategyPattern.interfaces.Human;

import java.util.Comparator;

public class ComparatorAge implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return Integer.compare(h1.getAge(), h2.getAge());
    }
}
