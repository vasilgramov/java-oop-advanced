package p01_database.models;

import javax.naming.OperationNotSupportedException;

public class Database {
    private static final int INITIAL_CAPACITY = 16;

    private int[] elements;
    private int pointer;

    private int capacity;

    private Database() {
        this.pointer = 0;
        this.capacity  = INITIAL_CAPACITY;
        this.elements = new int[INITIAL_CAPACITY];
    }

    public Database(int... ints) {
        this();

        this.setElements(ints);
    }

    public int[] getElements() {
        return this.elements;
    }

    private void setElements(int[] elements) {
        for (int element : elements) {
            this.elements[this.pointer++] = element;
        }
    }

    public void add(Integer element) throws OperationNotSupportedException {
        if (element == null) {
            throw new OperationNotSupportedException("Element should not be null!");
        }

        if (!hasSpace()) {
            expand();
        }

        this.elements[this.pointer++] = element;
        this.capacity++;
    }

    public int remove() throws OperationNotSupportedException {
        if (this.capacity == 0) {
            throw new OperationNotSupportedException("Array is empty!");
        }

        this.capacity--;
        int lastElement = this.elements[--this.pointer];
        this.elements[this.pointer] = 0;
        return lastElement;
    }

    public int[] fetch() {
        return this.elements;
    }

    private void expand() {
        int[] newElements = new int[this.capacity * 2];
        for (int i = 0; i < this.elements.length; i++) {
            newElements[i] = this.elements[i];
        }

        this.elements = newElements;
    }

    private boolean hasSpace() {
        return this.elements.length >= capacity;
    }
}
