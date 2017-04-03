package p07_customLinkedList.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p07_customLinkedList.models.CustomLinkedList;

public class CustomLinkedListTests {
    private static final int[] ELEMENTS_TO_BE_ADDED = new int[] { 1, 2, 3, 4, 5, 6 };

    private CustomLinkedList<Integer> customLinkedList;

    @Before
    public void init() {
        this.customLinkedList = new CustomLinkedList<Integer>();
        for (int i : ELEMENTS_TO_BE_ADDED) {
            this.customLinkedList.add(i);
        }
    }

    @Test
    public void testAddingElement() {
        int elementToAdd =  15;

        this.customLinkedList.add(15);

        Assert.assertEquals(true, this.customLinkedList.contains(elementToAdd));
    }

    @Test
    public void testRemovingElement() {
        int elementToBeRemoved = ELEMENTS_TO_BE_ADDED[ELEMENTS_TO_BE_ADDED.length / 2];

        this.customLinkedList.remove(elementToBeRemoved);

        Assert.assertEquals(false, this.customLinkedList.contains(elementToBeRemoved));
    }

    @Test
    public void getNthElement() {
        int expectedElement = 6;
        int n = 5;
        int result = this.customLinkedList.get(n);

        Assert.assertEquals(expectedElement, result);
    }

    @Test
    public void removeAt() {
        int index = ELEMENTS_TO_BE_ADDED.length - 1;
        int element = ELEMENTS_TO_BE_ADDED[index];

        this.customLinkedList.removeAt(index);

        Assert.assertEquals(false, this.customLinkedList.contains(element));
    }

    @Test
    public void testIndexOf() {
        int searchedElement = ELEMENTS_TO_BE_ADDED[0];
        int expected = 0;
        int result = this.customLinkedList.indexOf(searchedElement);


        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSet() {
        int index = 2;
        int expected = 999;
        this.customLinkedList.set(index, expected);

        int elementAtIndex = this.customLinkedList.get(index);

        Assert.assertEquals(expected, elementAtIndex);
    }
}
