package ru.astondevs.l8.cats;

public abstract class Animal {
    static int countAnimals = 0;
    private String name;

    Animal(String name){
        countAnimals++;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void Running(int length);

    public abstract void Swimming(int length);

    public static int getCountAnimals(){ //Получение количества животных
        return countAnimals;
    }
}
