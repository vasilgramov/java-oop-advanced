package p02_extendedDatabase.models;

import javax.naming.OperationNotSupportedException;
import java.util.*;

public class Database {
    private Map<Long, Person> personByID;

    public Database(Person... people) throws OperationNotSupportedException {
        this.personByID = new LinkedHashMap<>();

        this.setPeopleID(people);
    }

    public Map<Long, Person> getPersonByID() {
        return this.personByID;
    }

    private void setPeopleID(Person[] people) throws OperationNotSupportedException {
        for (Person person : people) {
            this.addPerson(person);
        }
    }

    public void addPerson(Person person) throws OperationNotSupportedException {
        if (this.personByID.containsKey(person.getId())) {
            throw new OperationNotSupportedException("Person with the same ID exists");
        }

        this.personByID.put(person.getId(), person);
    }

    public Person findById(long id) throws OperationNotSupportedException {
        if (!this.personByID.containsKey(id)) {
            throw new OperationNotSupportedException("There is not a person with same ID");
        }

        return this.personByID.get(id);
    }

    public long[] findByName(String name) {
        List<Long> ids = new ArrayList<>();

        for (Person person : personByID.values()) {
            if (person.getName().equals(name)) {
                ids.add(person.getId());
            }
        }

        long[] idsAsArray = new long[ids.size()];
        for (int i = 0; i < ids.size(); i++) {
            idsAsArray[i] = ids.get(i);
        }

        return idsAsArray;
    }
}
