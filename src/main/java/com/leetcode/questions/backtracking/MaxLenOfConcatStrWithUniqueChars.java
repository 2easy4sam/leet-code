package com.leetcode.questions.backtracking;

import java.util.List;

public class MaxLenOfConcatStrWithUniqueChars {

    private int max;

    public int maxLength(List<String> arr) {
        max = 0;

        for (String str : arr) {
            int[] cnt = new int[26];
            // check if string contains duplicate chars
            for (char c : str.toCharArray()) {
                if (cnt[c - 'a'] > 0) {
                    arr.remove(str);
                }
                cnt[c - 'a']++;
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            dfs(new StringBuilder(), arr, i);
        }

        return max;
    }

    private void dfs(StringBuilder sb, List<String> arr, int i) {
        String str = arr.get(i);

        for (char c : str.toCharArray()) {
            if (sb.indexOf(Character.toString(c)) > -1) return;
        }

        sb.append(str);
        max = Math.max(max, sb.length());

        for (int j = i + 1; j < arr.size(); j++) {
            dfs(new StringBuilder(sb), arr, j);
        }
    }
}
