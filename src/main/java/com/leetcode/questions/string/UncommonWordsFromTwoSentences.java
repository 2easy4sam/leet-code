package com.leetcode.questions.string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UncommonWordsFromTwoSentences {

    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();

        String[] words1 = A.split(" ");
        String[] words2 = B.split(" ");

        for (String word : words1)
            map.put(word, map.getOrDefault(word, 0) + 1);
        for (String word : words2)
            map.put(word, map.getOrDefault(word, 0) + 1);

        List<String> singleWords = map.entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> e.getKey())
                .collect(Collectors.toList());

        return singleWords.toArray(new String[0]);
    }
}
