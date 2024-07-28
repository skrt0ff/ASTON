package org.example.factorial;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FactorialTest {
    Factorial factorial;

    @BeforeMethod
    public void setUp() throws Exception {
        factorial = new Factorial();
    }

    @Test
    public void testGetFactorialPositiveInteger() {
        Assert.assertEquals(factorial.getFactorial(5), 120);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testGetFactorialNegativeInteger() {
        factorial.getFactorial(-5);
    }

    @Test
    public void testGetFactorialZero() {
        Assert.assertEquals(factorial.getFactorial(0), 1);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testGetFactorialOverFlow(){
        factorial.getFactorial(13);
    }
}