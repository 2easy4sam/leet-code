package com.leetcode.questions;

public class ReverseWordsInStringIII {
    public String reverseWords(String s) {
        if (s.length() == 0) return s;
        String delimiter = "";
        String[] words = s.split("\\s");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            sb.append(delimiter).append(reverseWord(word));
            delimiter = " ";
        }

        return sb.toString();
    }

    private String reverseWord(String word) {
        char[] charArr = word.toCharArray();

        for (int i = 0, j = charArr.length - 1; i < j; i++, j--) {
            char tmp = charArr[i];
            charArr[i] = charArr[j];
            charArr[j] = tmp;
        }

        return new String(charArr);
    }
}
