package com.leetcode.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class KeyboardRow {
    private static final char[] ROW_1 = new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
    private static final char[] ROW_2 = new char[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
    private static final char[] ROW_3 = new char[]{'z', 'x', 'c', 'v', 'b', 'n', 'm'};
    private static final char[][] ROWS = new char[][]{ROW_1, ROW_2, ROW_3};

    String[] findWords(String[] words) {
        List<String> result = new ArrayList();

        for (String word : words) {
            int[] counts = new int[26];
            char[] charArr = word.toCharArray();

            for (char c : charArr) {
                counts[Character.toLowerCase(c) - 'a']++;
            }

            for (char[] row : ROWS) {
                int count = 0;

                for (char c : row) {
                    count += counts[c - 'a'];
                }

                if (count == word.length()) {
                    result.add(word);
                    break;
                }
            }
        }

        return result.stream().toArray(String[]::new);
    }

    public String[] findWords2(String[] words) {
        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
    }
}
