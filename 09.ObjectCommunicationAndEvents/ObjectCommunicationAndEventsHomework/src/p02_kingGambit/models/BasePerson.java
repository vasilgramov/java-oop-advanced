package p02_kingGambit.models;

import p02_kingGambit.models.interfaces.Attackable;
import p02_kingGambit.models.interfaces.Nameable;

/**
 * Created by vladix on 4/12/17.
 */
public abstract class BasePerson implements Nameable, Attackable {

    private String name;

    protected BasePerson(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
