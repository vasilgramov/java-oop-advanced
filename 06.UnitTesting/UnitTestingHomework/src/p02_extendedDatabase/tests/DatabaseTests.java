package p02_extendedDatabase.tests;

import org.junit.Assert;
import org.junit.Test;
import p02_extendedDatabase.models.Database;
import p02_extendedDatabase.models.Person;

import javax.naming.OperationNotSupportedException;
import java.util.Map;

public class DatabaseTests {

    @Test
    public void addingFewPeople() throws OperationNotSupportedException {
        Person[] people = { new Person(3, "Ani"), new Person(2, "The baby"), new Person(1, "Cute little baby") };

        Database database = new Database(people);

        Map<Long, Person> addedPeople = database.getPersonByID();
        int index = 0;
        Person[] toCompare = new Person[3];
        for (Person person : addedPeople.values()) {
            toCompare[index++] = person;
        }

        for (int i = 0; i < people.length; i++) {
            Assert.assertSame(people[i], toCompare[i]);
        }
    }

    @Test
    public void searchById() throws OperationNotSupportedException {
        Person[] people = { new Person(3, "Ani"), new Person(2, "The baby"), new Person(1, "Cute little baby") };

        Database database = new Database(people);

        Person expected = people[0];
        Person found = database.findById(3L);

        Assert.assertSame(expected, found);
    }
}

