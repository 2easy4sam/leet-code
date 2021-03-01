package com.leetcode.questions.dfs;

import java.util.*;

public class PyramidTransitionMatrix {

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        /*
        - map to keep all triplet combos with keys being the pair and values being sets of
        strings that make valid triplets
        - keys will be integers (bit-manipulated)
        - use a StringBuilder to build up the next level
        - return true when next level is size 1
        */

        Map<Integer, Set<Character>> map = new HashMap<>();
        for (String triplet : allowed) {
            int c0 = charToInt(triplet.charAt(0));
            int c1 = charToInt(triplet.charAt(1));
            int c2 = charToInt(triplet.charAt(2));

            int key1 = c0 | c1;
            addValue(map, key1, triplet.charAt(2));

            int key2 = c0 | c2;
            addValue(map, key2, triplet.charAt(1));

            int key3 = c1 | c2;
            addValue(map, key3, triplet.charAt(0));
        }

        return dfs(map, bottom, new StringBuilder(bottom), 0, bottom.length());
    }

    private boolean dfs(Map<Integer, Set<Character>> map, String curr, StringBuilder next, int idx, int len) {
        if (next.length() == len) {
            if (len == 1) return true;
            return dfs(map, next.toString(), new StringBuilder(), 0, len - 1);
        } else {
            int key = charToInt(curr.charAt(idx)) | charToInt(curr.charAt(idx + 1));
            Set<Character> vals = map.get(key);

            for (char val : vals) {
                next.append(val);
                if (dfs(map, curr, next, idx + 1, len)) return true;
                next.setLength(next.length() - 1);
            }
        }

        return false;
    }

    private void addValue(Map<Integer, Set<Character>> map, int key, char val) {
        Set<Character> set = map.getOrDefault(key, new HashSet<>());
        set.add(val);
        map.put(key, set);
    }

    private int charToInt(char c) {
        return 1 << (c - 'A');
    }
}
