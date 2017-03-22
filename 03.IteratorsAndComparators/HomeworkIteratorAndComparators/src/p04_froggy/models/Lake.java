package p04_froggy.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake<E> implements Iterable<E> {
    private List<E> elements;

    public Lake() {
        this.elements = new ArrayList<E>();
    }

    public void addElement(E element) {
        this.elements.add(element);
    }

    @Override
    public Iterator<E> iterator() {
        return new Frog<E>(this.elements);
    }
}
