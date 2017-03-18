package p08_militaryElite.models;

import p08_militaryElite.interfaces.SpecialisedSoldier;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private String corps;

    protected SpecialisedSoldierImpl(int id, String name, String lastName, double salary, String corps) {
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(String.format("\nCorps: %s\n", this.getCorps()));

        return builder.toString();
    }
}
