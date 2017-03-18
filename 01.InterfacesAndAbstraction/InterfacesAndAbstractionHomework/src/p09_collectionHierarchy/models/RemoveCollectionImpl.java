package p09_collectionHierarchy.models;

import p09_collectionHierarchy.interfaces.RemoveCollection;

import java.util.ArrayList;
import java.util.List;

public class RemoveCollectionImpl implements RemoveCollection {
    private List<String> elements;

    public RemoveCollectionImpl() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int add(String element) {
        this.elements.add(0, element);
        return 0;
    }

    @Override
    public String remove() {
        String lastElement = this.elements.get(this.elements.size() - 1);
        this.elements.remove(lastElement);
        return lastElement;
    }
}
