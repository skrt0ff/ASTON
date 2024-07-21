package ru.astondevs.l8.cats;

public class Dog extends Animal{
    static int countDogs = 0;
    private String name;

    public Dog(String name) {
        countDogs++;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void Running(int lenght) {
        if (lenght < 0) {
            System.out.println("Что-то не так");
        } else if (lenght == 0) {
            System.out.println(getName() + " стоит");
        } else if (lenght >= 1 && lenght <= 500) {
            System.out.println(getName() + " пробежал " + lenght + " м");
        } else {
            System.out.println("Ошибка, " + getName() + " устал");
        }
    }
    public void Swimming(int lenght) {
        if (lenght < 0) {
            System.out.println("Что-то не так");
        } else if (lenght == 0) {
            System.out.println(getName() + " плавает на месте");
        } else if (lenght >= 1 && lenght <= 10) {
            System.out.println(getName() + " проплыл " + lenght + " м");
        } else {
            System.out.println("Спасайте собаку!");
        }
    }

    public static int getCountDogs() { //Получение количества собак
        return countDogs;
    }
}
