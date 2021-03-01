package com.leetcode.questions.string;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);

        /*
        - create two sets, one for keeping track of the words (from wordList) that have been reached already, the other for keeping track of the remainder of wordList
        - generate all permutations of the current word, add the ones that exist in wordList to the other set (BFS)
        */
        // base-case
        if (!words.contains(endWord)) return 0;
        Set<String> reached = new HashSet<>(Collections.singleton(beginWord));

        int depth = 1;

        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<>();

            for (String s : reached) {
                // generate all permutations of s
                toAdd.addAll(generatePerms(s, words));
            }
            if (toAdd.isEmpty()) return 0;
            reached = toAdd;
            depth++;
        }

        return depth;
    }

    private Set<String> generatePerms(String str, Set<String> words) {
        Set<String> res = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char[] charArr = str.toCharArray();

            for (char c = 'a'; c <= 'z'; c++) {
                charArr[i] = c;
                String perm = new String(charArr);

                if (words.contains(perm)) {
                    res.add(perm);
                    words.remove(perm);
                }
            }
        }

        return res;
    }
}
