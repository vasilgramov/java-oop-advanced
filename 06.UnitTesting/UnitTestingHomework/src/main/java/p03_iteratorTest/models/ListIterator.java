package p03_iteratorTest.models;

import javax.naming.OperationNotSupportedException;

public class ListIterator<E> {
    private E[] elements;
    private int cursor;

    public ListIterator(E[] elements) throws OperationNotSupportedException {
        this.cursor = 0;

        this.setElements(elements);
    }


    private void setElements(E[] elements) throws OperationNotSupportedException {
        if (elements == null) {
            throw new OperationNotSupportedException("Elements should not be null!");
        }

        this.elements = elements;
    }

    public boolean move() {
        if (this.cursor + 1 < this.elements.length) {
            this.cursor += 1;
            return true;
        }

        return false;
    }

    public boolean hasNext() {
        if (this.cursor + 1 < this.elements.length) {
            return true;
        }

        return false;
    }

    public void print() {
        if (this.elements.length == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }

        System.out.println(this.elements[this.cursor]);
    }

}
