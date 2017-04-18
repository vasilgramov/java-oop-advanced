package main.bg.softuni.dataStructures;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by vladix on 4/17/17.
 */
public class SimpleSortedList<E extends Comparable<E>> implements SimpleOrderedBag<E> {

    private static final int DEFAULT_SIZE = 16;

    private E[] innerCollections;
    private int size;
    private Comparator<E> comparator;

    //-----------------------------------------------------------------------------
    //-----------------------------------------------------------------------------

    public SimpleSortedList(Class<E> type) {
        this(type, DEFAULT_SIZE);
    }

    public SimpleSortedList(Class<E> type, Comparator<E> comparator) {
        this(type, comparator, DEFAULT_SIZE);
    }

    public SimpleSortedList(Class<E> type, int capacity) {
        this(type, Comparable::compareTo, capacity);
    }

    public SimpleSortedList(Class<E> type, Comparator<E> comparator, int capacity) {
        this.initInnerCollections(type, capacity);
        this.comparator = comparator;
    }

    //-----------------------------------------------------------------------------
    //-----------------------------------------------------------------------------

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean remove(E element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }

        boolean hasBeenRemoved = false;
        int indexOfElement = 0;
        for (int i = 0; i < this.innerCollections.length; i++) {
            if (this.innerCollections[i].compareTo(element) == 0) {
                indexOfElement = i;
                hasBeenRemoved = true;
                break;
            }
        }

        if (hasBeenRemoved) {
             for (int i = indexOfElement; i < this.size() - 1; i++) {
                 this.innerCollections[i] = this.innerCollections[i + 1];
             }

             this.innerCollections[this.size() - 1] = null;
             this.size--;
        }

        return hasBeenRemoved;
    }

    @Override
    public int capacity() {
        return this.innerCollections.length;
    }

    @Override
    public void add(E element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }

        if (this.size >= this.innerCollections.length) {
            this.resize();
        }

        this.innerCollections[this.size++] = element;
        Arrays.sort(this.innerCollections, 0, this.size, this.comparator);
    }

    @Override
    public void addAll(Collection<E> elements) {
        if (elements == null) {
            throw new IllegalArgumentException();
        }

        if (this.size + elements.size() >= this.innerCollections.length) {
            this.multiResize(elements);
        }

        for (E element : elements) {
            this.add(element);
        }
    }

    @Override
    public String joinWith(String delimiter) {
        if (delimiter == null) {
            throw new IllegalArgumentException();
        }

        StringBuilder builder = new StringBuilder();
        for (E element : this) {
            builder.append(element);
            builder.append(delimiter);
        }

        builder.setLength(builder.length() - delimiter.length());
        return builder.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new SortedListIterator();
    }

    //-----------------------------------------------------------------------------
    //-----------------------------------------------------------------------------

    @SuppressWarnings("unchecked")
    private void initInnerCollections(Class<E> type, int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative!");
        }

        this.innerCollections = (E[]) Array.newInstance(type, capacity);
    }

    private void resize() {
        E[] newCollection = Arrays.copyOf(
                this.innerCollections,
                this.innerCollections.length * 2);

        this.innerCollections = newCollection;
    }

    private void multiResize(Collection<E> elements) {
        int newSize = this.innerCollections.length * 2;
        while (this.size + elements.size() >= newSize) {
            newSize *= 2;
        }

        E[] newCollection = Arrays.copyOf(
                this.innerCollections,
                newSize);
        this.innerCollections = newCollection;
    }

    private final class SortedListIterator implements Iterator<E> {

        private int cursor;

        private SortedListIterator() {
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return this.cursor < size;
        }

        @Override
        public E next() {
            return innerCollections[this.cursor++];
        }
    }
}
