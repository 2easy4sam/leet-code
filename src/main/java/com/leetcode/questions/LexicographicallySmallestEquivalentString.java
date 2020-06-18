package com.leetcode.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class LexicographicallySmallestEquivalentString {
    public Map<Character, Set<Character>> smallestEquivalentString(String A, String B, String S) {
        Map<Character, Set<Character>> eqMap = new HashMap<>();
        int len = A.length();

        for (int i = 0; i < len; i++) {
            char c1 = A.charAt(i);
            char c2 = B.charAt(i);
            if (c1 == c2) continue;

            updateMap(c1, c2, eqMap);
            updateMap(c2, c1, eqMap);
        }

        return eqMap;
    }

    private void updateMap(char c1, char c2, Map<Character, Set<Character>> map) {
        if (map.containsKey(c1)) {
            map.get(c1).add(c2);

            for (char c : map.get(c1)) {
                if (c == c2) continue;
                Set<Character> charSet = map.get(c);

                if (charSet != null) {
                    charSet.add(c2);
                } else {
                    charSet = new TreeSet();
                    charSet.add(c2);
                    map.put(c, charSet);
                }

                updateMap(c, c2, map);
            }
        } else {
            Set<Character> set = new TreeSet();
            set.add(c2);
            map.put(c1, set);
        }
    }
}
