package p04_listUtilities;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
    public static <E extends Comparable<E>> E getMin(List<E> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty!");
        }

        E min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(min) < 0) {
                min = list.get(i);
            }
        }

        return min;
    }

    public static <E extends Comparable<E>> E getMax(List<E> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty!");
        }

        E max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(max) > 0) {
                max = list.get(i);
            }
        }

        return max;
    }

    public static List<Integer> getNullIndices(List<? extends Comparable<?>> list) {
        List<Integer> nullIndeces = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                nullIndeces.add(i);
            }
        }

        return nullIndeces;
    }

    // animal
    // cat
    // kitten

    // dog

    public static <T> void flatten(List<? super T> destination, List<List<? extends T>> list) {
        for (List<? extends T> inner : list) {
            destination.addAll(inner);
        }
    }

    public static <T> void addAll(List<? super T> destination, List<? extends T> source) {
        for (T e : source) {
            destination.add(e);
        }
    }
}
