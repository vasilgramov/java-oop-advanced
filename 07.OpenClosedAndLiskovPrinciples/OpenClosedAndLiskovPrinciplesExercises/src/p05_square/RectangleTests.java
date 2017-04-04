package p05_square;

import org.junit.Assert;
import org.junit.Test;

public class RectangleTests {

    @Test
    public void getSidesTest() {
        Rectangle rect = new Rectangle(10, 5);
        Assert.assertEquals(10, rect.getWidth());
        Assert.assertEquals(5, rect.getHeight());
    }

    @Test
    public void getAreaTest() {
        Rectangle rect = new Rectangle(5, 10);
        Assert.assertEquals(50, rect.getArea());
    }

    @Test
    public void areaTest() {
        Rectangle rect = new Rectangle(5, 3);
        Rectangle square = new Square(10);

        int current1 = rect.getArea();
        int current2 = square.getArea();

        rect.increase();
        square.increase();

        int current3 = rect.getArea();
        int current4 = square.getArea();

        System.out.println(current1 + " -> " + current3);
        System.out.println(current2 + " -> " + current4);
    }
}
