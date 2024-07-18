package ru.astondevs.l8.cats;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() { //Получение количеста еды в миске
        return food;
    }

    public void addFood(int food){ //Добавление еды в миску
        this.food += food;
    }

    public void decreaseFood(int appetite){ //Вычитание съеденной еды
        this.food -= appetite;
    }

    public boolean checkFood(int appetite){ //Проверка на пустую миску
        return (this.food - appetite) >= 0;
    }
}
