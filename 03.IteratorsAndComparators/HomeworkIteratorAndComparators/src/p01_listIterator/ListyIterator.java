package p01_listIterator;

import java.util.Iterator;

public class ListyIterator<E> implements Iterable<E> {
    private E[] elements;
    private int pointer;

    public ListyIterator(E... elements) {
        this.pointer = 0;

        this.setElements(elements);
    }

    public E[] getElements() {
        return this.elements;
    }

    private void setElements(E[] elements) {
        this.elements = elements;
    }

    public boolean move() {
        if (this.pointer + 1 < this.elements.length) {
            this.pointer++;
            return true;
        }

        return false;
    }

    public boolean hasNext() {
        return pointer + 1 < elements.length;
    }

    public void print() {
        if (this.elements.length == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }

        System.out.println(this.elements[this.pointer]);
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<E> {
        private int index;

        private MyIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < elements.length;
        }

        @Override
        public E next() {
            return elements[this.index++];
        }
    }
}
