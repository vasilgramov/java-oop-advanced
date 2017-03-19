package p07_customList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CustomList<E extends Comparable<E>> implements Iterable<E> {
    private List<E> elements;

    public CustomList() {
        this.elements = new ArrayList<E>();
    }

    public void add(E element) {
        this.elements.add(element);
    }

    public E remove(int index) {
        return this.elements.remove(index);
    }

    public boolean contains(E element) {
        for (E e : this.elements) {
            if (e.equals(element)) {
                return true;
            }
        }

        return false;
    }

    public void swap(int firstIndex, int secondIndex) {
        E temp = this.elements.get(firstIndex);
        this.elements.set(firstIndex, this.elements.get(secondIndex));
        this.elements.set(secondIndex, temp);
    }

    public int countGreaterThan(E element) {
        int count = 0;
        for (E e : this.elements) {
            if (e.compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }

    public E getMax() {
        E max = this.elements.get(0);
        for (int i = 1; i < this.elements.size(); i++) {
            if (this.elements.get(i).compareTo(max) > 0) {
                max = this.elements.get(i);
            }
        }

        return max;
    }

    public E getMin() {
        E min = this.elements.get(0);
        for (int i = 1; i < this.elements.size(); i++) {
            if (this.elements.get(i).compareTo(min) < 0) {
                min = this.elements.get(i);
            }
        }

        return min;
    }

    public void print() {
        for (E element : this.elements) {
            System.out.println(element);
        }
    }

    public void sort() {
        Collections.sort(this.elements);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < elements.size();
            }

            @Override
            public E next() {
                return elements.get(currentIndex++);
            }
        };
    }
}
