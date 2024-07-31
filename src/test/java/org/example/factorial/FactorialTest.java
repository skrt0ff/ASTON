package org.example.factorial;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FactorialTest {
    //Валидные данные: 0-12, граничные значения: (-1,0,1), (11,12,13)
    //Невалидные данные: от -бесконечности до -1 (включительно), граничные значения: (-2,-1,0)
    //Невалидные данные: от 13 до +бесконечности, граничные значения: (12,13,14)
    //Итог: -2,-1,0,1,11,12,13,14
    Factorial factorial;

    @BeforeMethod
    public void setUp() throws Exception {
        factorial = new Factorial();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testGetFactorialBoundaryNegativeInt2() {
        factorial.getFactorial(-2);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testGetFactorialBoundaryNegativeInt1() {
        factorial.getFactorial(-1);
    }

    @Test
    public void testGetFactorialZero() {
        Assert.assertEquals(factorial.getFactorial(0), 1);
    }

    @Test
    public void testGetFactorialPositiveInt1() {
        Assert.assertEquals(factorial.getFactorial(1), 1);
    }

    @Test
    public void testGetFactorialPositiveInt11() {
        Assert.assertEquals(factorial.getFactorial(11), 39916800);
    }

    @Test
    public void testGetFactorialPositiveInt12() {
        Assert.assertEquals(factorial.getFactorial(12), 479001600);
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