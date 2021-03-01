package com.leetcode.questions.string;

import java.util.ArrayList;
import java.util.List;

/*
Given a string s. Return all the words vertically in the same order
in which they appear in s.
Words are returned as a list of strings, complete with spaces when is
necessary. (Trailing spaces are not allowed).
Each word would be put on only one column and that in one column there
will be only one word.
*/
public class PrintWordsVertically {
    public List<String> printVertically(String s) {
        // the width is determined by the number of words
        // the depth (number of lists) is determined by the length of the longest word
        String[] words = s.split(" ");
        List<String> list = new ArrayList<>();
        // m being width of each word, n being the number of lists
        int m = words.length, n = 0;
        for (String word : words) n = Math.max(n, word.length());

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();

            for (String word : words) {
                sb.append(word.length() > i ? word.charAt(i) : " ");
            }

            int end = sb.length() - 1;

            while (sb.charAt(end) == ' ') end--;
            list.add(sb.delete(end + 1, m).toString());
        }

        return list;
    }
}
