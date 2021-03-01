package com.leetcode.questions.array;

import java.util.HashMap;
import java.util.Map;

/*
TODO:
*/
public class ReplaceTheSubstrForBalancedStr {

    public int balancedString(String s) {
        int n = s.length(), maxCnt = n / 4;
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int i = 0, j = n - 1;
        while (i < n && map.get(s.charAt(i)) == maxCnt) {
            i++;
        }

        while (j > 0 && map.get(s.charAt(j)) == maxCnt) {
            j--;
        }

        return i == n - 1
                ? 0
                : j - i + 1;
    }
}
