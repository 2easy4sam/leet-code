package com.leetcode.questions;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {

        int nDiffs = 0;

        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                if (s.charAt(i + 1) == s.charAt(j)) {
                    i++;
                    nDiffs++;
                } else if (s.charAt(i) == s.charAt(j - 1)) {
                    j--;
                    nDiffs++;
                } else {
                    return false;
                }

                if (nDiffs > 1) return false;
            }
        }

        return true;
    }
}
