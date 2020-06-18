package com.leetcode.questions.backtracking;

public class FlipGameII {
    public boolean canWin(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            // consecutive + signs
            if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == '+') {
                char[] charArr = s.toCharArray();
                charArr[i] = charArr[i + 1] = '-';
                if (dfs(new String(charArr), true)) return true;
            }
        }

        return false;
    }

    private boolean dfs(String s, boolean myTurn) {
        boolean flippable = false;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == '+') {
                char[] charArr = s.toCharArray();
                charArr[i] = charArr[i + 1] = '-';
                flippable = true;
                if (dfs(new String(charArr), !myTurn)) return true;
            }
        }

        return !flippable && myTurn;
    }
}
