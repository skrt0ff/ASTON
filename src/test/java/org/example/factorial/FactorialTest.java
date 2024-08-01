package org.example.factorial;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {
    //Граничные значения: -1,0,1,12,13,14,6
    Factorial factorial;

    @BeforeEach
    public void setUp() throws Exception {
        factorial = new Factorial();
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 1",
            "12, 479001600",
            "6, 720"
    })

    public void testGetFactorialWithCsvSource(int actual, int expected) {
        assertEquals(expected, factorial.getFactorial(actual));
    }

    @Test
    public void testGetFactorialNegativeBoundary1() {
        assertThrows(IllegalArgumentException.class, () -> factorial.getFactorial(-1));
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