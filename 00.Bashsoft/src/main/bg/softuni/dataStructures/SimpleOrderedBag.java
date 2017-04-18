package main.bg.softuni.dataStructures;

import java.util.Collection;

/**
 * Created by vladix on 4/17/17.
 */
public interface SimpleOrderedBag<E extends Comparable<E>> extends Iterable<E> {

    boolean remove(E element);

    int capacity();

    void add(E element);

    void addAll(Collection<E> elements);

    int size();

    String joinWith(String delimiter);

}
