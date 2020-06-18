package com.leetcode.questions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCountEngine {
    private Map<String, Integer> wordCount;

    WordCountEngine() {
        wordCount = new HashMap<>();
    }

    void countWords(String document) {
        String[] rawWords = document.split(" ");

        for (String rawWord : rawWords) {
            String word = rawWord.toLowerCase().replaceAll("[^a-zA-Z]", "");
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // sort the map by count
        wordCount = wordCount.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (k, v) -> v, LinkedHashMap::new));
    }

    void print() {
        String separator = "";

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.print(separator + "[\"" + entry.getKey() + "\", \"" + entry.getValue() + "\"]");
            separator = ", ";
        }
    }
}
