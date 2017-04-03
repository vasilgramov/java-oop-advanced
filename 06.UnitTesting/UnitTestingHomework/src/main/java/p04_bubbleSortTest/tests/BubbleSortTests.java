package p04_bubbleSortTest.tests;

import org.junit.Assert;
import org.junit.Test;
import p04_bubbleSortTest.models.Bubble;

import javax.naming.OperationNotSupportedException;

public class BubbleSortTests {
    private Bubble<Integer> bubble;
    private Integer[] elementsToBeSorted;


    @Test
    public void sortWithZeroElements() throws OperationNotSupportedException {
        this.elementsToBeSorted = new Integer[0];

        this.bubble = new Bubble<Integer>(this.elementsToBeSorted);

        this.bubble.applyBubbleSort();

        Integer[] sortedElements = this.bubble.getElements();
    }

    @Test
    public void sortWithOneElement( ) throws OperationNotSupportedException {
        this.elementsToBeSorted = new Integer[] { 111 };

        this.bubble = new Bubble<Integer>(elementsToBeSorted);
        this.bubble.applyBubbleSort();

        Integer[] sortedElements = this.bubble.getElements();

        Assert.assertArrayEquals(this.elementsToBeSorted, sortedElements);
    }

    @Test
    public void sortWithTwoElements() throws OperationNotSupportedException {
        this.elementsToBeSorted = new Integer[] { 50, 5 };

        this.bubble = new Bubble<Integer>(this.elementsToBeSorted);
        this.bubble.applyBubbleSort();

        Integer[] expectedElements = new Integer[] { 5, 50 };
        Integer[] sortedElements = this.bubble.getElements();

        Assert.assertArrayEquals(expectedElements, sortedElements);
    }

    @Test
    public void sortWithThreeElemetns() throws OperationNotSupportedException {
        this.elementsToBeSorted = new Integer[] { 1000, 10, 100 };

        this.bubble = new Bubble<Integer>(this.elementsToBeSorted);
        this.bubble.applyBubbleSort();

        Integer[] expectedElements = new Integer[] { 10, 100, 1000 };
        Integer[] sortedElements = this.bubble.getElements();

        Assert.assertArrayEquals(expectedElements, sortedElements);
    }

    @Test
    public void sortWithMoreElements() throws OperationNotSupportedException {
        Integer[] expected = new Integer[] { 2, 3, 4, 5, 15, 19, 26, 27, 36, 38, 44, 46, 47, 48, 50 };

        this.elementsToBeSorted = new Integer[] { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48 };
        this.bubble = new Bubble<Integer>(this.elementsToBeSorted);

        this.bubble.applyBubbleSort();

        Integer[] sorted = this.bubble.getElements();

        Assert.assertArrayEquals(expected, sorted);
    }
}
