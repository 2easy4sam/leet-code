package com.leetcode.questions.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStrWithAtMostTwoDistinctChars {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0, i = 0, n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        for (int j = 0; j < n; j++) {
            char c1 = s.charAt(j);
            map.put(c1, map.getOrDefault(c1, 0) + 1);

            while (map.size() > 2) {
                char c2 = s.charAt(i++);
                if (map.put(c2, map.get(c2) - 1) == 1) {
                    map.remove(c2);
                }
            }

            max = Math.max(max, j - i + 1);
        }

        return max;
    }
}
