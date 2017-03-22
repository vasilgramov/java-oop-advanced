package p03_stackIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stack<E> implements Iterable<E> {
    private List<E> elements;

    public Stack() {
        this.elements = new ArrayList<E>();
    }

    public void push(E element) {
        this.elements.add(element);
    }

    public E pop() {
        if (this.elements.size() == 0) {
            throw new IllegalArgumentException("No elements");
        }

        return this.elements.remove(this.elements.size() - 1);
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIter();
    }

    private class StackIter implements Iterator<E> {
        private int cursor;

        private StackIter() {
            this.cursor = elements.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return this.cursor >= 0;
        }

        @Override
        public E next() {
            return elements.get(this.cursor--);
        }
    }
}
