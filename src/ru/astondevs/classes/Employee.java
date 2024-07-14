package ru.astondevs.classes;

public class Employee {
    private String FIO;
    private String position;
    private String email;
    private long number;
    private long salary;
    private int age;

    public Employee(String FIO, String position, String email, long number, long salary, int age) {
        this.FIO = FIO;
        this.position = position;
        this.email = email;
        this.number = number;
        this.salary = salary;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("ФИО: " + this.FIO);
        System.out.println("Должность: " + this.position);
        System.out.println("Почта: " + this.email);
        System.out.println("Номер телефона: " + this.number);
        System.out.println("Зарплата: " + this.salary);
        System.out.println("Возраст: " + this.age);
    }
}
