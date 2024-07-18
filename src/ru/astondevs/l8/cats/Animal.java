package ru.astondevs.l8.cats;

public class Animal {
    static int countAnimals = 0;
    private String name;

    Animal(String name){
        this.name = name;
        countAnimals++;
    }

    public void Running(int length){
        if (length < 0) {
            System.out.println("Что-то не так");
        } else if (length == 0) {
            System.out.println(name + " стоит");
        } else {
            System.out.println(name + " пробежал " + length + " м");
        }
    }

    public void Swimming(int length){
        if (length < 0) {
            System.out.println("Что-то не так");
        } else if (length == 0) {
            System.out.println(name + " стоит");
        } else {
            System.out.println(name + " проплыл" + length + " м");
        }
    }

    public static int getCountAnimals(){ //Получение количества животных
        return countAnimals;
    }

    public String getName() { //Получение имени
        return name;
    }
}
