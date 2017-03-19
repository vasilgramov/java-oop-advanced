package p04_genericSwapIntegers;

import java.util.ArrayList;
import java.util.List;

public class GenericList<E> {
    private List<E> elements;

    public GenericList() {
        this.elements = new ArrayList<E>();
    }

    public List<E> getElements() {
        return this.elements;
    }

    public void add(E element) {
        this.elements.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        E temp = this.elements.get(firstIndex);
        this.elements.set(firstIndex, this.elements.get(secondIndex));
        this.elements.set(secondIndex, temp);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (E el : this.getElements()) {
            builder.append(String.format("%s: %s\n", el.getClass().getName(), el));
        }

        return builder.toString().trim();
    }
}
