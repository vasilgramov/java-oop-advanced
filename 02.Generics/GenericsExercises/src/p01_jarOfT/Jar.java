package p01_jarOfT;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<E> {
    private Deque<E> elements;

    public Jar() {
        this.elements = new ArrayDeque<E>();
    }

    public void add(E element) {
        this.elements.add(element);
    }

    public E remove() {
        return this.elements.removeLast();
    }
}
