package p06_genericCountMethodDoubles;

import java.util.ArrayList;
import java.util.List;

public class ComparableList<E extends Comparable<E>> {
    private List<E> elements;

    public ComparableList() {
        this.elements = new ArrayList<E>();
    }

    public List<E> getElements() {
        return this.elements;
    }

    public void add(E element) {
        this.elements.add(element);
    }

    public int findBiggerThan(E element) {
        int count = 0;
        for (E e : this.getElements()) {
            if (e.compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }
}
