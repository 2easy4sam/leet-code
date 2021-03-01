package com.leetcode.questions.string;

import java.util.HashSet;
import java.util.Set;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int max = 0;
        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) set.add(c);

        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'A');
            if (set.contains(c)) {
                max = Math.max(max, calcMax(s, c, k));
            }
        }

        return max;
    }

    private int calcMax(String s, char c, int k) {
        int i = 0, j, max = 0;

        for (j = 0; j < s.length(); j++) {
            if (s.charAt(j) != c) k--;

            while (k < 0) {
                if (s.charAt(i++) != c) k++;
            }

            max = Math.max(max, j - i + 1);
        }

        return max;
    }
}
