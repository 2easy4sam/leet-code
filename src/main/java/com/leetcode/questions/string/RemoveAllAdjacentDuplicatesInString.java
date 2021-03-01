package com.leetcode.questions.string;

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s, int k) {
        if (s == null || k > s.length()) return s;
        StringBuilder sb = new StringBuilder(s);

        int i = 0, j = 0;

        while (j < sb.length()) {
            if (j - i + 1 == k && sb.charAt(i) == sb.charAt(j)) {
                sb.delete(i, j + 1);
                i = 0;
                j = 0;
                continue;
            }
            if (sb.charAt(i) != sb.charAt(j)) {
                i = j;
            }
            j++;
        }

        return sb.toString();
    }
}
