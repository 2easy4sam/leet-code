package com.leetcode.questions.backtracking;

import java.util.HashSet;
import java.util.Set;

public class SplitAStringIntoMaxNumOfUniqueSubstr {
    /*
    - intuition:
        - assuming a string contains no duplicate chars, the max no. of unique substrings
        we can get from it is n, n being the length of the string
            - this suggests that we should always start with substr length = 1
        - use a set to keep track of existing substrings
        - WHEN a substring of length n already exists
          THEN retract to the previous state and generate substr n + 1
        - in case a string contains only 1 character, return 1
    */
    private int max;

    public int maxUniqueSplit(String s) {
        if (s == null || s.isEmpty()) return 0;

        max = 1;

        for (int len = 1; len <= s.length(); len++) {
            Set<String> set = new HashSet<>();
            set.add(s.substring(0, len));
            dfs(set, s, 0, len);
        }

        return max;
    }

    private void dfs(Set<String> set, String s, int idx, int len) {
        idx += len;

        if (idx == s.length()) {
            max = Math.max(max, set.size());
            return;
        }

        for (int newLen = 1; idx + newLen <= s.length(); newLen++) {
            String sub = s.substring(idx, idx + newLen);
            if (!set.add(sub)) continue;
            dfs(set, s, idx, newLen);
            set.remove(sub);
        }
    }
}