package ru.astondevs.l8.cats;

public class Animal {
    static int countAnimals = 0;

    Animal(){
        countAnimals++;
    }

    public void Running(int length){
        if (length < 0) {
            System.out.println("Что-то не так");
        } else if (length == 0) {
            System.out.println("Животное стоит");
        } else {
            System.out.println("Животное пробежало " + length + " м");
        }
    }

    public void Swimming(int length){
        if (length < 0) {
            System.out.println("Что-то не так");
        } else if (length == 0) {
            System.out.println("Животное стоит");
        } else {
            System.out.println("Животное проплыло" + length + " м");
        }
    }

    public static int getCountAnimals(){ //Получение количества животных
        return countAnimals;
    }
}
