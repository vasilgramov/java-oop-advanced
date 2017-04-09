package app.database;

import app.contracts.Modelable;
import app.contracts.Repository;
import app.utility.Constants;
import app.exeptions.DuplicateModelException;
import app.exeptions.NonExistantModelException;

import java.util.HashMap;
import java.util.Map;

public class RepositoryImpl implements Repository {
    private Map<String, Modelable> itemsByModel;

    public RepositoryImpl() {
        this.setItemsByModel(new HashMap<>());
    }

    public Map<String, Modelable> getItemsByModel() {
        return this.itemsByModel;
    }

    private void setItemsByModel(Map<String, Modelable> itemsByModel) {
        this.itemsByModel = itemsByModel;
    }

    @Override
    public void add(Modelable item) throws DuplicateModelException {
        if (this.itemsByModel.containsKey(item.getModel())) {
            throw new DuplicateModelException(Constants.DuplicateModelMessage);
        }

        this.itemsByModel.put(item.getModel(), item);
    }

    @Override
    public Modelable getItem(String model) throws NonExistantModelException {
        if (!this.itemsByModel.containsKey(model)) {
            throw new NonExistantModelException(Constants.NonExistentModelMessage);
        }

        return this.itemsByModel.get(model);
    }
}
