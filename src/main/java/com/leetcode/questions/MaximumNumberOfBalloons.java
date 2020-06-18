package com.leetcode.questions;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBalloons {
    private static final char[] BALLOON = new char[]{'b', 'a', 'l', 'l', 'o', 'o', 'n'};
    private static final char[] BALON = new char[]{'b', 'a', 'l', 'o', 'n'};

    public int maxNumberOfBalloons(String text) {
        int[] charCounts = new int[26];

        for (int i = 0; i < text.length(); i++) {
            charCounts[text.charAt(i) - 'a']++;
        }

        boolean stop = false;
        int count = 0;

        while (!stop) {
            for (char c : BALLOON) {
                if (charCounts[c - 'a'] == 0) {
                    stop = true;
                    break;
                } else {
                    charCounts[c - 'a']--;
                }
            }

            if (!stop) count++;
        }

        return count;
    }

    public int maxNumberOfBalloons2(String text) {
        int count = 0;
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (!charCountMap.containsKey(c)) {
                charCountMap.put(c, 1);
            } else {
                charCountMap.put(c, charCountMap.get(c) + 1);
            }
        }

        for (char c : BALON) {


            Integer val = charCountMap.get(c);
            if (val == null) return 0;
            if (c == 'b') {
                count = val;
            } else if (c == 'l' || c == 'o') {
                val /= 2;
                if (val == 0) return 0;
            }

            count = Math.min(count, val);
        }

        return count;
    }
}
