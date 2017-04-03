package p02_extendedDatabase.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p02_extendedDatabase.models.Database;
import p02_extendedDatabase.models.Person;

import javax.naming.OperationNotSupportedException;
import java.util.Map;

public class DatabaseTests {
    private static final Person[] people = new Person[] {
            new Person(3, "Pesho"), new Person(2, "Gosho"), new Person(1, "Stamat")
    };

    private Database database;

    @Before
    public void init() throws OperationNotSupportedException {
        this.database = new Database(people);
    }

    @Test
    public void addingFewPeople() throws OperationNotSupportedException {
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
        Person expected = people[0];
        Person found = database.findById(3L);

        Assert.assertSame(expected, found);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldNotFindPerson() throws OperationNotSupportedException {
        database.findById(5);
    }


}

