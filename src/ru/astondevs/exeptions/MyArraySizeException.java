package ru.astondevs.exeptions;

public class MyArraySizeException extends Exception {
    MyArraySizeException() {
        System.out.println("Размерость массива должна быть 4х4!");
    }
}
