package p08_militaryElite.models;

import p08_militaryElite.interfaces.LeutenantGeneral;
import p08_militaryElite.interfaces.Private;

import java.util.ArrayList;
import java.util.Collection;

public class LeutenantGeneralImp extends PrivateImpl implements LeutenantGeneral {
    private Collection<Private> privates;

    public LeutenantGeneralImp(int id, String name, String lastName, double salary) {
        super(id, name, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public Collection<Private> getPrivates() {
        return this.privates;
    }

    public void addPrivate(Private privateSoldier) {
        this.privates.add(privateSoldier);
    }
}
