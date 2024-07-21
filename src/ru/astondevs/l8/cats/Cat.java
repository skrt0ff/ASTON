package ru.astondevs.l8.cats;

public class Cat extends Animal {
    /*Расширить задачу, добавив для котов возможность кушать из миски, выполнив следующие пункты:
    Сделать так, чтобы в миске с едой не могло получиться отрицательного количества еды
    (например, в миске 10 еды, а кот пытается покушать 15-20).
    Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
    Если коту удалось покушать (хватило еды), сытость = true.
    Считаем, что если коту мало еды в миске, то он её просто не трогает,
     то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
    Создать массив котов и миску с едой,
    попросить всех котов покушать из этой миски и потом вывести информацию о сытости котов в консоль.
    Добавить метод, с помощью которого можно было бы добавлять еду в миску.*/
    static int countCats = 0;
    private boolean satiety; //поле сытость, голодны по умолчанию
    private int appetite;
    private String name;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
        countCats++;
    }


    public String getName() {
        return name;
    }

    public void Running(int lenght) {
        if (lenght < 0) {
            System.out.println("Что-то не так");
        } else if (lenght == 0) {
            System.out.println(getName() + " стоит");
        } else if (lenght >= 1 && lenght <= 200) {
            System.out.println("Кот пробежал " + lenght + " м");
        } else {
            System.out.println("Ошибка, Кот устал");
        }
    }
    public void Swimming() {
        System.out.println("Кот не умеет плавать :(");
    }

    public static int getCountCats() { //Получение количества котов
        return countCats;
    }

    public int getAppetite() { //Получение количества корма, нужное для сытости кота
        return appetite;
    }

    public void changeSatiety() { //Изменение поля сытости кота
        this.satiety = true;
    }
}
