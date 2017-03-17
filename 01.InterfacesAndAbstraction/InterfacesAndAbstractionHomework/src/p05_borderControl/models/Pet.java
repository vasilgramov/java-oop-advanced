package p05_borderControl.models;

import p05_borderControl.interfaces.Birthdate;

public class Pet implements Birthdate{
    private String name;
    private String birthdate;

    public Pet(String name, String birthdate) {
        this.setName(name);
        this.setBirthdate(birthdate);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String getBirthdate() {
        return this.birthdate;
    }

    private void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}
