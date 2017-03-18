package p09_collectionHierarchy.models;

import p09_collectionHierarchy.interfaces.AddCollection;

import java.util.ArrayList;
import java.util.List;

public class AddCollectionImpl implements AddCollection {
    private List<String> elements;

    public AddCollectionImpl() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int add(String element) {
        this.elements.add(element);
        return this.elements.size() - 1;
    }
}
