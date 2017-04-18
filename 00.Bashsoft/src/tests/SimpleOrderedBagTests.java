package tests;

import main.bg.softuni.dataStructures.SimpleOrderedBag;
import main.bg.softuni.dataStructures.SimpleSortedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by vladix on 4/18/17.
 */
public class SimpleOrderedBagTests {

    public static final int INITIAL_SIZE = 0;
    public static final int INITIAL_CAPACITY = 16;
    private SimpleOrderedBag<String> names;

    @Before
    public void init() {
        this.names = new SimpleSortedList<String>(String.class);
    }

    @Test
    public void testEmptyCtor() {
        this.names = new SimpleSortedList<String>(String.class);
        Assert.assertEquals(INITIAL_SIZE, this.names.size());
        Assert.assertEquals(INITIAL_CAPACITY, this.names.capacity());
    }

    @Test
    public void testCtorWithInitialCapacity() {
        int expectedCapacity = 333;
        this.names = new SimpleSortedList<String>(String.class, expectedCapacity);
        Assert.assertEquals(INITIAL_SIZE, this.names.size());
        Assert.assertEquals(expectedCapacity, this.names.capacity());
    }

    @Test
    public void testCtorWithInitialComparator() {
        this.names = new SimpleSortedList<String>(String.class, String.CASE_INSENSITIVE_ORDER);
        Assert.assertEquals(INITIAL_SIZE, this.names.size());
        Assert.assertEquals(INITIAL_CAPACITY, this.names.capacity());
    }

    @Test
    public void testCtorWithAllParameters() {
        int expectedCapacity = 333;
        this.names = new SimpleSortedList<String>(String.class, String.CASE_INSENSITIVE_ORDER, expectedCapacity);
        Assert.assertEquals(INITIAL_SIZE, this.names.size());
        Assert.assertEquals(expectedCapacity, this.names.capacity());
    }

    @Test
    public void testAddIncreasesSize() {
        int expectedSize = 1;

        String name = "gosho";
        this.names.add(name);

        Assert.assertEquals(expectedSize, this.names.size());
        Assert.assertEquals(INITIAL_CAPACITY, this.names.capacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullThrowExcepion() {
        this.names.add(null);
    }

    @Test
    public void testAddUnsortedDataIsHeldSorted() {
        String[] addedNames = { "Rosen", "Georgi", "Balkan" };

        this.names.add(addedNames[0]);
        this.names.add(addedNames[1]);
        this.names.add(addedNames[2]);

        String[] expectedNames = { "Balkan", "Georgi", "Rosen" };

        int index = 0;
        for (String name : this.names) {
            Assert.assertEquals(expectedNames[index++], name);
        }
    }

    @Test
    public void testAddingMoreThanInitialCapacity() {
        String[] addedNames = {
                "1", "2", "3", "4", "1", "2", "3", "4", "1", "2", "3", "4", "1", "2", "3", "4", "1"
        };

        for (String addedName : addedNames) {
            this.names.add(addedName);
        }

        Assert.assertEquals(17, this.names.size());
        Assert.assertEquals(32, this.names.capacity());
    }

    @Test
    public void testAddingAllFromCollectionIncreasesSize() {
        List<String> firstCollection = new ArrayList<>();
        List<String> secondCollection = new ArrayList<>();
        Collections.addAll(firstCollection, "1","2","3");
        Collections.addAll(secondCollection, "1", "2", "3");

        this.names.addAll(firstCollection);
        this.names.addAll(secondCollection);

        int expectedSize = 6;
        Assert.assertEquals(expectedSize, this.names.size());
        Assert.assertEquals(INITIAL_CAPACITY, this.names.capacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddingAllFromNullThrowsException() {
        List<String> collection = null;

        this.names.addAll(collection);
    }

    @Test
    public void testAddAllKeepsSorted() {
        List<String> collection = new ArrayList<>();
        Collections.addAll(collection, "PESHO", "BOSHO", "ASHO");


        String[] expectedElements = new String[] { "ASHO", "BOSHO", "PESHO" };
        this.names.addAll(collection);
        int index = 0;
        for (String name : this.names) {
            Assert.assertEquals(expectedElements[index++], name);
        }
    }

    @Test
    public void testRemoveValidElementDecreasesSize() {
        List<String> collection = new ArrayList<>();
        Collections.addAll(collection, "PESHO", "BOSHO", "ASHO");

        this.names.addAll(collection);
        boolean hasRemoved = this.names.remove("BOSHO");
        boolean expectedRemoved = true;
        int expectedSize = 2;

        Assert.assertEquals(expectedRemoved, hasRemoved);
        Assert.assertEquals(expectedSize, this.names.size());
        Assert.assertEquals(INITIAL_CAPACITY, this.names.capacity());
    }


    @Test
    public void testRemoveValidElementRemovesSelectedOne() {
        List<String> collection = new ArrayList<>();
        Collections.addAll(collection, "PESHO", "BOSHO", "ASHO");

        this.names.addAll(collection);
        collection.remove("BOSHO");

        String[] expectedNames = new String[] { "ASHO", "BOSHO", "PESHO" };
        int index = 0;
        for (String name : this.names) {
            Assert.assertEquals(expectedNames[index++], name);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovingNullThrowsException() {
        this.names.remove(null);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testJoinWithNull() {
        this.names.joinWith(null);
    }

    @Test
    public void testJoinWorksFine() {
        String expected = "ASHO, BOSHO, POSHO";

        List<String> collection = new ArrayList<>();
        Collections.addAll(collection, "POSHO", "BOSHO", "ASHO");
        this.names.addAll(collection);

        String result = this.names.joinWith(", ");

        Assert.assertEquals(expected, result);
    }
}
