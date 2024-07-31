package org.example.factorial;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {
    //Валидные данные: 0-12, граничные значения: (-1,0,1), (11,12,13)
    //Невалидные данные: от -бесконечности до -1 (включительно), граничные значения: (-2,-1,0)
    //Невалидные данные: от 13 до +бесконечности, граничные значения: (12,13,14)
    //Итог: -2,-1,0,1,11,12,13,14
    Factorial factorial;

    @BeforeEach
    public void setUp() throws Exception {
        factorial = new Factorial();
    }

    @Test
    public void testGetFactorialNegativeBoundary2() {
        assertThrows(IllegalArgumentException.class, () -> factorial.getFactorial(-2));
    }

    @Test
    public void testGetFactorialNegativeBoundary1() {
        assertThrows(IllegalArgumentException.class, () -> factorial.getFactorial(-1));
    }

    @Test
    public void testGetFactorialZero() {
        int actual = factorial.getFactorial(0);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFactorialPositiveBoundaryInt() {
        int actual = factorial.getFactorial(1);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFactorialPositiveBoundary11() {
        int actual = factorial.getFactorial(11);
        int expected = 39916800;
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFactorialPositiveBoundary12() {
        int actual = factorial.getFactorial(12);
        int expected = 479001600;
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFactorialOverFlowNegativeBoundary13() {
        assertThrows(ArithmeticException.class, () -> factorial.getFactorial(13));
    }

    @Test
    public void testGetFactorialOverFlowNegativeBoundary14() {
        assertThrows(ArithmeticException.class, () -> factorial.getFactorial(14));
    }

}