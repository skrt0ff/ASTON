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

    public void Running(int length){
        if (length < 0) {
            System.out.println("Что-то не так");
        } else if (length == 0) {
            System.out.println(name + " стоит");
        } else {
            System.out.println(name + " пробежало " + length + " м");
        }
    }

    public void Swimming(int length){
        if (length < 0) {
            System.out.println("Что-то не так");
        } else if (length == 0) {
            System.out.println(name + " стоит");
        } else {
            System.out.println(name + " проплыло" + length + " м");
        }
    }

    public static int getCountAnimals(){ //Получение количества животных
        return countAnimals;
    }
}
