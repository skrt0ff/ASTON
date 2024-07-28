import ru.astondevs.collection.PhoneBook;
import ru.astondevs.collection.WordAction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static ru.astondevs.collection.PhoneBook.*;

public class Main {
    public static void main(String[] args) {
        /*1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
        Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        Посчитать, сколько раз встречается каждое слово. (реализовать с использованием коллекций)*/
        System.out.println("______Task 1______");
        String[] words = new String[]{
                "btcusdt", "ethusdt", "woousdt", "xrpusdt", "btcusdt",
                "pepeusdt", "suiusdt", "ethusdt", "aaveusdt", "maticusdt"
        };

        Set<String> uniqueWords = WordAction.getUniqueWords(words);
        System.out.println("Уникальные слова:");
        for (String word : uniqueWords) {
            System.out.println(word);
        }

        Map<String, Integer> wordCounts = WordAction.countWords(words);
        System.out.println("Итоговое количество уникальных слов, сколько раз встречается каждое слово:\n " + wordCounts);
        System.out.println("\n");

        /*2. Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
        В этот телефонный справочник с помощью метода add() можно добавлять записи,
        а с помощью метода get() искать номер телефона по фамилии.
        Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
        тогда при запросе такой фамилии должны выводиться все телефоны.*/
        System.out.println("______Task 2______");
        addPhoneNumber("Иванов", "+79145553458");
        addPhoneNumber("Иванов", "+79431234332");
        addPhoneNumber("Петров", "+78883332211");

        try {
            System.out.println("Номера телефонов с фамилией Иванов: " + getPhoneNumbers("Иванов"));
            System.out.println("Номера телефонов с фамилией Петров: " + getPhoneNumbers("Петров"));
            System.out.println("Номера телефонов с фамилией Сидоров: " + getPhoneNumbers("Сидоров"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}