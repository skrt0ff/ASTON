package ru.astondevs.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private static HashMap<String, ArrayList<String>> phoneBooks = new HashMap<>();

    public static void addPhoneNumber(String lastName, String phoneNumber) {
        if (phoneBooks.containsKey(lastName)) {
            phoneBooks.get(lastName).add(phoneNumber);
        } else {
            ArrayList<String> numbers = new ArrayList<>();
            numbers.add(phoneNumber);
            phoneBooks.put(lastName, numbers);
        }
    }

    public static ArrayList<String> getPhoneNumbers(String lastName) {
        if (phoneBooks.containsKey(lastName)) {
            return phoneBooks.get(lastName);
        } else {
            throw new IllegalArgumentException("Телефоны с фамилией " + lastName + " не найдены.");
        }
    }
}
