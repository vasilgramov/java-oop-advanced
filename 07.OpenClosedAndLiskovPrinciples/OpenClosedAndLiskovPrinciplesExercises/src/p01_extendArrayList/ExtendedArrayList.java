package p01_extendArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class ExtendedArrayList<E extends Comparable<E>> extends ArrayList<E> {

    public E max() {
        Iterator<E> iterator = super.iterator();
        E max = null;
        while (iterator.hasNext()) {
            E next = iterator.next();

            if (max == null || next.compareTo(max) > 0) {
                max = next;
            }
        }

        return max;
    }

    public E min() {
        Iterator<E> iterator = super.iterator();
        E min = null;
        while (iterator.hasNext()) {
            E next = iterator.next();

            if (min == null || next.compareTo(min) < 0) {
                min = next;
            }
        }

        return min;
    }
}
