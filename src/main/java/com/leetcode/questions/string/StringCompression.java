package com.leetcode.questions.string;

public class StringCompression {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();

        int i = 0, j = 0;

        while (j <= chars.length) {
            if (j < chars.length && chars[i] == chars[j]) {
                j++;
            } else {
                sb.append(chars[i]).append(j - i > 1 ? j - i : "");
                if (j == chars.length) break;
                i = j;
            }
        }

        i = 0;

        while (i < sb.length()) {
            chars[i] = sb.charAt(i++);
        }

        return sb.length();
    }
}
