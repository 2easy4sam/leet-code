package com.leetcode.questions.string;

import java.util.HashSet;
import java.util.Set;

public class LongestRepeatingSubstring {
    public int longestRepeatingSubstring(String s) {
        int n = s.length();
        int winSize = n - 1;

        Set<String> set = new HashSet<>();

        for (int i = 0; i + winSize <= n; i++) {
            String sub = s.substring(i, i + winSize);
            if (!set.add(sub)) return sub.length();

            if (i + winSize == n) {
                if (--winSize < 1) break;
                i = 0;
            }
        }

        return 0;
    }
}
