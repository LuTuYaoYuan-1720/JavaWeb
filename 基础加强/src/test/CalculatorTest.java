package test;

import Junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    @Before
    public void init() {
        System.out.println("begin");
    }

    @After
    public void close() {
        System.out.println("last");
    }

    @Test
    public void testAdd() {
        Calculator c = new Calculator();
        int result = c.add(1, 2);
        Assert.assertEquals(3, result);
    }
}
