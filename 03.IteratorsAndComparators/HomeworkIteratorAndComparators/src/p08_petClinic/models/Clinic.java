package p08_petClinic.models;

import p08_petClinic.interfaces.Animal;
import p08_petClinic.interfaces.Hospital;

import java.util.Iterator;


public class Clinic implements Hospital {
    private String name;
    private int roomsCount;

    private Animal[] animals;

    public Clinic(String name, int roomsCount) {
        this.animals = new Animal[roomsCount];

        this.setName(name);
        this.setRoomsCount(roomsCount);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public int getRoomsCount() {
        return this.roomsCount;
    }

    private void setRoomsCount(int roomsCount) {
        if (roomsCount % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }

        this.roomsCount = roomsCount;
    }

    public boolean add(Animal pet) {
        AddRoomsIterator roomsIterator = new AddRoomsIterator();
        while (roomsIterator.hasNext()) {
            Animal animal = roomsIterator.next();
            if (animal == null) {
                this.animals[roomsIterator.cursor] = pet;
                return true;
            }
        }

        return false;
    }

    public boolean release() {
        ReleaseRoomsIterator releaseRoomsIterator = new ReleaseRoomsIterator();
        while (releaseRoomsIterator.hasNext()) {
            Animal animal = releaseRoomsIterator.next();
            if (animal != null) {
                this.animals[releaseRoomsIterator.cursor - 1] = null;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean hasEmptyRooms() {
        for (Animal animal : this.animals) {
            if (animal == null) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void print() {
        for (int i = 0; i < this.animals.length; i++) {
            Animal animal = this.animals[i];

            if (animal == null) {
                System.out.println("Room empty");
            } else {
                System.out.println(animal);
            }
        }
    }

    @Override
    public void printRoom(int room) {
        if (this.animals[room - 1] == null) {
            System.out.println("Room empty");
            return;
        }

        System.out.println(this.animals[room - 1]);
    }

    private final class AddRoomsIterator implements Iterator<Animal> {
        private int cursor;
        private int counter;
        private boolean isFirst;
        private int pointer;

        private AddRoomsIterator() {
            this.cursor = animals.length / 2;
            this.counter = 0;
            this.isFirst = true;
            this.pointer = 1;
        }

        @Override
        public boolean hasNext() {
            return this.counter < animals.length;
        }

        @Override
        public Animal next() {
            this.counter++;

            if (this.isFirst) {
                this.isFirst = false;
                return animals[this.cursor];
            } else {
                int temp = this.pointer;
                this.pointer++;

                if (temp % 2 == 1) {
                    this.cursor -= temp;
                    return animals[this.cursor];
                } else {
                    this.cursor += temp;
                    return animals[this.cursor];
                }
            }
        }
    }

    private final class ReleaseRoomsIterator implements Iterator<Animal> { //TODO
        private int cursor;
        private int counter;
        private boolean hasStartedFromTheBeginning;

        private ReleaseRoomsIterator() {
            this.cursor = animals.length / 2;
            this.counter = 0;
            this.hasStartedFromTheBeginning = false;
        }

        @Override
        public boolean hasNext() {
            return this.counter < animals.length;
        }

        @Override
        public Animal next() {
            if (this.cursor < animals.length && !hasStartedFromTheBeginning) {
                this.counter++;
                return animals[this.cursor++];
            } else {
                hasStartedFromTheBeginning = true;
                this.cursor = 0;
                this.counter++;
                return animals[this.cursor++];
            }
        }
    }
}
