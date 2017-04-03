package p06_hack.tests;

import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Target;

public class MethodTesting {

    @Test
    public void testMathAbs() {
        int n1 = 5;
        int n2 = 8;

        int expeted = 3;
        int result = Math.abs(n1 - n2);

        Assert.assertEquals(expeted, result);
    }


    @Test
    public void testSystemLineSeparator() {
        String lineSeparator = System.lineSeparator();

        Assert.assertEquals("\n", lineSeparator);
    }

    @Test
    public void testMathFloor() {
        double n1 = 5.0;
        double n2 = 2.0;

        int expected = 2;

        int result = (int) Math.floor(n1 / n2);

        Assert.assertEquals(expected, result);
    }
}
