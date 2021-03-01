package com.leetcode.questions.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    private List<List<String>> output;

    public List<List<String>> partition(String s) {
        int n = s.length();
        output = new ArrayList<>();

        for (int parts = n; parts >= 1; parts--) {
            dfs(new ArrayList<>(), s, parts);
        }

        return output;
    }

    private void dfs(List<String> list, String s, int parts) {
        if (parts == 1) {
            if (isPalindrome(s)) {
                list.add(s);
                output.add(list);
                list.remove(list.size() - 1);
            }
        } else {
            for (int len = 1; len < s.length(); len++) {
                String sub = s.substring(0, len);
                if (!isPalindrome(sub)) continue;
                list.add(sub);
                dfs(list, s.substring(len), parts - 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }

        return true;
    }
}
