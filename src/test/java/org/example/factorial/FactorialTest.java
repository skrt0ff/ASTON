package org.example.factorial;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {
    Factorial factorial;

    @BeforeEach
    public void setUp() throws Exception {
        factorial = new Factorial();
    }

    @Test
    public void testGetFactorialPositiveInt() {
        int actual = factorial.getFactorial(5);
        int expected = 120;
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFactorialNegativeInt() {
        assertThrows(IllegalArgumentException.class, () -> factorial.getFactorial(-5));
    }

    @Test
    public void testGetFactorialZero() {
        int actual = factorial.getFactorial(0);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFactorialOverFlow() {
        assertThrows(ArithmeticException.class, () -> factorial.getFactorial(13));
    }

}