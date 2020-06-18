package com.leetcode.questions.string;

public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int cnt = 0, len = 2, n = s.length();

        while (len <= n) {
            for (int i = 0; i <= n - len; i++) {
                if (isPalindromic(s.substring(i, i + len))) cnt++;
            }
            len++;
        }

        return cnt + s.length();
    }

    private boolean isPalindromic(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
