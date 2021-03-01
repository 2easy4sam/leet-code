package com.leetcode.questions.string;

public class ShortestPalindrome {
    private int begin, end;

    public String shortestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";

        if (new StringBuilder(s).reverse().toString().equals(s)) return s;

        begin = end = -1;

        for (int i = 0; i < s.length(); i++) {
            if (helper(s, i, i) || helper(s, i, i + 1)) break;
        }

        if (begin == 0) {
            StringBuilder sb = new StringBuilder(s.substring(end + 1));
            return sb.reverse().append(s).toString();
        }

        int i = 1;
        while (i < s.length() && s.charAt(0) == s.charAt(i)) {
            i++;
        }

        StringBuilder sb = new StringBuilder(s.substring(i));

        return sb.reverse().append(s).toString();
    }

    private boolean helper(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        if (--j - ++i > 1) {
            begin = i;
            end = j;
            return true;
        }

        return false;
    }
}
