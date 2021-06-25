package com.leetcode.questions.string;

public class LongestSubstrOfAllVowelsInOrder1839 {
    public int longestBeautifulSubstring(String word) {
        int max = 0;
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};

        for (int i = 0, j = 0, v = 0; j < word.length(); ) {
            // starting from a, if the next vowel is not what we're looking for, start over again
            if (word.charAt(j) != vowels[v]) {
                v = 0;
                while (j < word.length() && word.charAt(j) != vowels[v]) j++;
                i = j;
            }

            while (j < word.length() && word.charAt(j) == vowels[v]) j++;
            if (v == 4) {
                max = Math.max(max, j - i);
                i = j;
            }
            v = (v + 1) % 5;
        }

        return max;
    }
}
