package app.contracts;

import app.exeptions.DuplicateModelException;
import app.exeptions.NonExistantModelException;

public interface Repository {

    void add(Modelable item) throws DuplicateModelException;

    Modelable getItem(String model) throws NonExistantModelException;

}
