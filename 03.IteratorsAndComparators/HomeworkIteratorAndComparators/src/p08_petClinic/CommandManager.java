package p08_petClinic;

import p08_petClinic.interfaces.Animal;
import p08_petClinic.interfaces.Hospital;
import p08_petClinic.models.Clinic;
import p08_petClinic.models.Pet;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private Map<String, Animal> animalByName;
    private Map<String , Hospital> hospitalByName;

    public CommandManager() {
        this.animalByName = new HashMap<>();
        this.hospitalByName = new HashMap<>();
    }

    public void createPet(String name, int age, String kind) {
        Animal pet = new Pet(name, age, kind);
        this.animalByName.put(name, pet);
    }

    public void createClinic(String name, int roomsCount) {
        try {
            Hospital clinic = new Clinic(name, roomsCount);
            this.hospitalByName.put(name, clinic);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean addPet(String petName, String hospitalName) {
        if (this.animalByName.containsKey(petName) && this.hospitalByName.containsKey(hospitalName)) {
            Animal pet = this.animalByName.get(petName);
            Hospital clinic = this.hospitalByName.get(hospitalName);

            return clinic.add(pet);
        }

        return false;
    }

    public boolean release(String hospitalName) {
        if (this.hospitalByName.containsKey(hospitalName)) {
            Hospital hospital = this.hospitalByName.get(hospitalName);

            return hospital.release();
        }

        return false;
    }

    public boolean hasEmptyRooms(String hospitalName) {
        if (this.hospitalByName.containsKey(hospitalName)) {
            Hospital clinic = this.hospitalByName.get(hospitalName);
            return clinic.hasEmptyRooms();
        }

        return false;
    }

    public void print(String hospitalName) {
        if (this.hospitalByName.containsKey(hospitalName)) {
            Hospital hospital = this.hospitalByName.get(hospitalName);

            hospital.print();
        }
    }

    public void printRoom(String hospitalName, int room) {
        if (this.hospitalByName.containsKey(hospitalName)) {
            Hospital hospital = this.hospitalByName.get(hospitalName);

            hospital.printRoom(room);
        }
    }
}
