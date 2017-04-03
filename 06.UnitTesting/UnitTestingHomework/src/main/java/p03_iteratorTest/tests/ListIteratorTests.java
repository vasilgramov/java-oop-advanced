package p03_iteratorTest.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p03_iteratorTest.models.ListIterator;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;

public class ListIteratorTests {
    private static final String[] elements = new String[] { "1", "2", "3", "4", "5" };

    private ListIterator<String> listIterator;

    @Before
    public void init() throws OperationNotSupportedException {
        this.listIterator = new ListIterator<String>(elements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void createInstanceOfListIteratorWithNullCollection() throws OperationNotSupportedException {
        this.listIterator = new ListIterator<String>(null);
    }

    @Test
    public void createInstanceOfListIteratorCollection() throws OperationNotSupportedException, IllegalAccessException {
        Field elementsInListIterator = ListIterator.class.getDeclaredFields()[0];
        elementsInListIterator.setAccessible(true);
        Object o = elementsInListIterator.get(this.listIterator);
        Assert.assertSame(elements, o);
    }

    @Test
    public void shouldMoveInternalIndex() throws IllegalAccessException, OperationNotSupportedException {
        this.listIterator.move();

        Field internalIndex = ListIterator.class.getDeclaredFields()[1];
        internalIndex.setAccessible(true);
        int internalIndexValue = internalIndex.getInt(this.listIterator);

        int expectedInternalIndexValue = 1;

        Assert.assertEquals(expectedInternalIndexValue, internalIndexValue);
    }

    @Test
    public void shouldNotMoveInternalIndex() throws OperationNotSupportedException, NoSuchFieldException, IllegalAccessException {
        Field cursor = ListIterator.class.getDeclaredField("cursor");
        cursor.setAccessible(true);

        cursor.set(this.listIterator, elements.length - 1);

        boolean hasMoved = this.listIterator.move();
        boolean expected = false;

        Assert.assertEquals(expected, hasMoved);
    }

    @Test
    public void shouldHaveNext() throws OperationNotSupportedException {
        boolean hasNext = this.listIterator.hasNext();

        Assert.assertEquals(true, hasNext);
    }


    @Test
    public void shouldNotMove() throws OperationNotSupportedException, NoSuchFieldException, IllegalAccessException {
        Field cursor = ListIterator.class.getDeclaredField("cursor");
        cursor.setAccessible(true);

        cursor.set(this.listIterator, elements.length - 1);

        Assert.assertEquals(false, this.listIterator.hasNext());
    }

    @Test
    public void shouldPrintAllElements() throws NoSuchFieldException, IllegalAccessException {
        Field cursor = ListIterator.class.getDeclaredField("cursor");
        cursor.setAccessible(true);

        Field elementsInListIterator = ListIterator.class.getDeclaredField("elements");
        elementsInListIterator.setAccessible(true);

        for (int i = 0; i < elements.length; i++) {
            String currentElement = i + 1 + "";

            cursor.set(this.listIterator, i);
            String currentElementInListIterator = ((String[]) elementsInListIterator.get(this.listIterator))[cursor.getInt(this.listIterator)];

            Assert.assertEquals(currentElement, currentElementInListIterator);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void printMethodInEmptyCollection() throws OperationNotSupportedException {
        this.listIterator = new ListIterator<String>(new String[0]);

        this.listIterator.print();
    }
}
