package p01_defineInterfacePerson.models;

import p01_defineInterfacePerson.interfaces.Birthable;
import p01_defineInterfacePerson.interfaces.Identifiable;
import p01_defineInterfacePerson.interfaces.Person;

public class Citizen implements Person, Birthable, Identifiable {
   private String name;
   private int age;
   private String id;
   private String birthdate;

   public Citizen(String name, int age, String id, String birthdate) {
       this.setName(name);
       this.setAge(age);
        this.setId(id);
        this.setBirthdate(birthdate);
   }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
       this.age = age;
    }

    @Override
    public String getBirthdate() {
        return this.birthdate;
    }

    private void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String getId() {
        return this.id;
    }

    private void setId(String id) {
        this.id = id;
    }
}
