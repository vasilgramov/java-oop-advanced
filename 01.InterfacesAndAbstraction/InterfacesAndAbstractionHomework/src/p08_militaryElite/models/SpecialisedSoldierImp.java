package p08_militaryElite.models;

import p08_militaryElite.interfaces.SpecialisedSoldier;

public abstract class SpecialisedSoldierImp extends PrivateImpl implements SpecialisedSoldier {
    private String corps;

    protected SpecialisedSoldierImp(int id, String name, String lastName, double salary, String corps) {
        super(id, name, lastName, salary);
        this.setCorps(corps);
    }

    @Override
    public String getCorps() {
        return this.corps;
    }

    private void setCorps(String corps) {
        if (corps.equals("Airforces") || corps.equals("Marines")) {
            this.corps = corps;
        }
    }
}
