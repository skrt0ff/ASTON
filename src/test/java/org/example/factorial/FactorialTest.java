package org.example.factorial;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FactorialTest {
    //Граничные значения: -1,0,1,6,12,13,14
    Factorial factorial;

    @BeforeMethod
    public void setUp() throws Exception {
        factorial = new Factorial();
    }

    @DataProvider(name = "boundaryValues")
    public Object[][] boundaryValues() {
        return new Object[][]{
                {0, 1},
                {1, 1},
                {6, 720},
                {12, 479001600},
        };
    }

    @Test (dataProvider = "boundaryValues")
    public void testFactorialWithBoundary(int input, int expected) {
        int actual = factorial.getFactorial(input);
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testGetFactorialBoundaryNegativeInt1() {
        factorial.getFactorial(-1);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testGetFactorialOverFlowNegativeInt13(){
        factorial.getFactorial(13);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testGetFactorialOverFlowNegativeInt14(){
        factorial.getFactorial(14);
    }
}