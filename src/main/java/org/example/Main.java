package org.example;

import org.example.factorial.Factorial;

public class Main {
    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        try {
            System.out.println(factorial.getFactorial(12));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}