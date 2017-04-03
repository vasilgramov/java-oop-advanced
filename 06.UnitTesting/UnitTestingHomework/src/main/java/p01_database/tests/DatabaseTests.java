package p01_database.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p01_database.models.Database;

import javax.naming.OperationNotSupportedException;

public class DatabaseTests {
    Database database = new Database();
    int[] elementsToBeAdded = { 1, 2, 3, 4, 5 };

    @Before
    public void initializeDatabase() {
        int[] elementsToBeAdded = { 1, 2, 3, 4, 5 };
        database = new Database(elementsToBeAdded);
    }

    @Test
    public void addMethodIsAdding() throws OperationNotSupportedException {
        int lastAddedElement = 100;
        database.add(100);

        int lastElement = database.getElements()[5];

        Assert.assertEquals(lastElement, lastAddedElement);
    }

    @Test
    public void removeMethodIsRemoving() throws OperationNotSupportedException {
        int lastElement = database.remove();

        Assert.assertEquals(lastElement, 5);
    }

    @Test
    public void fetchAllElements() throws OperationNotSupportedException {
        int[] actualElements = new int[] { 1, 2, 3, 4, 5, 101, 102, 103, 104 };

        database.add(101);
        database.add(102);
        database.add(103);
        database.add(104);

        int[] elementsInDB = database.getElements();
        int[] elemenentsToCompare = new int[actualElements.length];
        for (int i = 0; i < elemenentsToCompare.length; i++) {
            elemenentsToCompare[i] = elementsInDB[i];
        }

        Assert.assertArrayEquals(actualElements, elemenentsToCompare);
    }

    @Test
    public void correctInitialization() {
        int[] elements = database.getElements();

        int[] actualElements = database.getElements();
        int[] elementToBeCompared = new int[elementsToBeAdded.length];
        for (int i = 0; i < elementToBeCompared.length; i++) {
            elementToBeCompared[i] = actualElements[i];
        }

        Assert.assertArrayEquals(elementsToBeAdded, elementToBeCompared);
    }
}
