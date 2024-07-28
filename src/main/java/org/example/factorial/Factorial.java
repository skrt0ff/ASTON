package org.example.factorial;

public class Factorial {
    public static int getFactorial(int f) {
        if (f < 0) {
            throw new IllegalArgumentException("Invalid factorial!");
        }

        int result = 1;
        try {
            for (int i = 1; i <= f; i++) {
                result = Math.multiplyExact(result, i);
            }
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Factorial too large!");
        }
        return result;
    }
}
