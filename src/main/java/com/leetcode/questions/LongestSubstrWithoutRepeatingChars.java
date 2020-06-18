package com.leetcode.questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestSubstrWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        // chars in the current substring
        HashSet<Character> set = new HashSet<>();
        String longest = "";
        int n = s.length();
        int i = 0, j = 1;
        set.add(s.charAt(i));

        while (j < n) {
            char c = s.charAt(j);
            String sub = s.substring(i, j + 1);

            if (set.add(c)) {
                if (sub.length() > longest.length()) longest = sub;
            } else {
                // substring contains duplicate chars
                // find the index of the first non-repeating char
                int k = firstNonRepeatingCharIdx(sub);
                i += k;
                set.clear();

                char[] arr = sub.substring(k).toCharArray();

                for (char ch : arr) {
                    set.add(ch);
                }
            }

            j++;
        }

        return Math.max(1, longest.length());
    }

    private int firstNonRepeatingCharIdx(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int idx = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                idx = map.get(c) + 1;
                break;
            } else {
                map.put(c, i);
            }
        }

        return idx;
    }
}
