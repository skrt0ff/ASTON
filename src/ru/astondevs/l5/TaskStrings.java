package ru.astondevs.l5;

public class TaskStrings {
    /*1. Создайте метод printThreeWords(),
    который при вызове должен отпечатать в столбец три слова: Orange, Banana, Apple.*/
    public static void printThreeWorlds(String a1, String a2, String a3) {
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
    }
    /*8. Напишите метод, которому в качестве аргументов передается строка и число, метод должен отпечатать в консоль указанную строку, указанное количество раз;*/
    public static void numberOfLines(String str, int n) {
        while (n != 0) {
            System.out.println(str);
            n--;
        }
    }
}
