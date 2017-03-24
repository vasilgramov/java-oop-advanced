package p09_linkedListTraversal.models;

import p09_linkedListTraversal.iterfaces.LinkedList;

import java.util.Iterator;

public class MyLinkedList<E> implements LinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    public MyLinkedList() {
        this.first = this.last = null;
        this.setSize(0);
    }

    @Override
    public int getSize() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    @Override
    public void add(E element) {
        if (this.getSize() == 0) {
            this.first = this.last = new Node<>(element);
        } else {
            Node<E> newLast = new Node<>(element);
            newLast.setPrev(this.last);
            this.last.setNext(newLast);

            this.last = newLast;
        }

        this.setSize(this.getSize() + 1);
    }

    @Override
    public boolean remove(E element) {
        if (this.first == null && this.last == null) {
            throw new IllegalArgumentException("List is empty!");
        }

        Node<E> current = this.first;
        while (current != null) {
            if (current.getValue() == element) {
                Node<E> prev = current.getPrev();
                Node<E> next = current.getNext();

                if (prev == null && next != null) {
                  this.first = next;
                  next.setPrev(null);
                } else if (next == null && prev != null) {
                    this.last = prev;
                    prev.setNext(null);
                } else {
                    prev.setNext(next);
                    next.setPrev(prev);
                }

                this.setSize(this.getSize() - 1);
                return true;
            }

            current = current.getNext();
        }

        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIter();
    }

    private class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> prev;

        private Node(T value) {
            this.setValue(value);
        }

        private T getValue() {
            return this.value;
        }

        private void setValue(T value) {
            this.value = value;
        }

        private Node<T> getNext() {
            return this.next;
        }

        private void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return this.prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }
    }

    private final class LinkedListIter implements Iterator<E> {
        private Node<E> current;

        private LinkedListIter() {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return this.current != null;
        }

        @Override
        public E next() {
            E toReturn = this.current.getValue();
            this.current = this.current.next;
            return toReturn;
        }
    }
}
