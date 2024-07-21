package ru.astondevs.exeptions;

public class MyArrayDataException extends Exception{
    MyArrayDataException(int row, int column) {
        System.out.println("Не удалось преобразовать данные в строке " + (row + 1)  + ", колонке " + (column + 1) + "!");
    }
}
