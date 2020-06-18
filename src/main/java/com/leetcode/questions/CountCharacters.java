package com.leetcode.questions;

public class CountCharacters {
    public int countCharacters(String[] words, String chars) {
        int sum = 0;

        for (String word : words) {
            int wordSum = 0;
            StringBuilder stringBuilder = new StringBuilder(chars);

            for (int i = 0; i < word.length(); i++) {
                int idx = stringBuilder.indexOf(Character.toString(word.charAt(i)));

                if (idx != -1) {
                    stringBuilder.deleteCharAt(idx);
                    wordSum++;
                }
            }

            if (wordSum == word.length()) sum += wordSum;
        }

        return sum;
    }
}
