package p04_froggy.models;

import java.util.Iterator;
import java.util.List;

class Frog<E> implements Iterator<E> {
    private int cursor;
    private int count;
    private List<E> elements;
    private boolean hasSetToOdd;

    public Frog(List<E> elements) {
        this.cursor = 0;
        this.count = 0;
        this.hasSetToOdd = false;

        this.setElements(elements);
    }

    private void setElements(List<E> elements) {
        this.elements = elements;
    }

    @Override
    public boolean hasNext() {
        return this.count < this.elements.size();
    }

    @Override
    public E next() {
        this.count++;

        if (this.cursor < this.elements.size()) {
            int currentCursor = this.cursor;
            this.cursor += 2;
            return this.elements.get(currentCursor);
        } else {
            if (!this.hasSetToOdd) {
                this.cursor = 1;
                this.hasSetToOdd = true;
            }

            int currentCursor = this.cursor;
            this.cursor += 2;
            return this.elements.get(currentCursor);
        }
    }
}
