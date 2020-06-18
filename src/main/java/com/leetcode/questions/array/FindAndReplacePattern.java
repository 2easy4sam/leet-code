package com.leetcode.questions.array;

import java.util.*;

/*
You have a list of words and a pattern, and you want to know which
words in words matches the pattern.

A word matches the pattern if there exists a permutation of letters p
so that after replacing every letter x in the pattern with p(x), we
get the desired word.

(Recall that a permutation of letters is a bijection from letters to
letters: every letter maps to another letter, and no two letters map
to the same letter.)

Return a list of the words in words that match the given pattern.
*/
public class FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] p = normalise(pattern);
        List<String> res = new ArrayList<>();

        for (String word : words) {
            if (Arrays.equals(p, normalise(word))) res.add(word);
        }

        return res;
    }

    private int[] normalise(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            map.putIfAbsent(s.charAt(i), map.size());
            res[i] = map.get(s.charAt(i));
        }

        return res;
    }
}
