package ru.astondevs.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordAction {

    public static Set<String> getUniqueWords(String[] words) {
        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word);
        }
        return uniqueWords;
    }

    public static Map<String, Integer> countWords(String[] words) {
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }
        return wordCounts;
    }
}
