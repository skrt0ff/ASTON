package ru.astondevs.l5;

public class TaskArrays {
    /*10. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;*/
    public void replaceValueArray(int[] replaceValue)  {

        System.out.println("Массив до: ");

        for (int i = 0; i < replaceValue.length; i++) {
            System.out.print(replaceValue[i]);
        }

        System.out.println("\n");
        System.out.println("Массив после: ");

        for (int i = 0; i < replaceValue.length; i++) {
            if (replaceValue[i] == 1) {
                replaceValue[i] = 0;
            } else {
                replaceValue[i] = 1;
            }
            System.out.print(replaceValue[i]);
        }
    }
    /*11. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100;*/
    public void fillArray(int size) {
        int[] fillArr = new int[size];
        for (int i = 0; i < fillArr.length; i++) {
            fillArr[i] = i + 1;
            System.out.print(fillArr[i] + " ");
        }
    }
    /*12. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;*/
    public void multiplyArray(int[] multiplyArray) {
        for (int i = 0; i < multiplyArray.length; i++) {
            if (multiplyArray[i] < 6) {
                multiplyArray[i] *= 2;
            }
        }
        for (int i = 0; i < multiplyArray.length; i++) {
            System.out.print(multiplyArray[i] + " ");
        }
    }
    /*13. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
     Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], ..., [n][n];*/
    public void diagonalArray(int x, int y) {
        int[][] arr = new int[x][y];

        for (int i = 0; i < arr.length; i++) {
            arr[i][arr.length - i - 1] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][i] = 1;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    /*Написать метод, принимающий на вход два аргумента: len и initialValue,
     и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue.*/
    public void initialArray(int len, int initialValue) {
        int[] myArray = new int[len];
        for (int i = 0; i < len; i++) {
            myArray[i] = initialValue;
        }
        for (int i = 0; i < len; i++) {
            System.out.print(myArray[i] + " ");
        }
    }
}
