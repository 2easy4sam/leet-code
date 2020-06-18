package com.leetcode.questions;

public class NumberOfLinesToWriteString {
    public int[] numberOfLines(int[] widths, String S) {
        int currentLineWidth = 0, lines = 1;

        for (int i = 0; i < S.length(); i++) {
            currentLineWidth += widths[S.charAt(i) - 'a'];

            if (currentLineWidth > 100) {
                lines++;
                currentLineWidth = widths[S.charAt(i) - 'a'];
            }
        }

        return new int[]{lines, currentLineWidth};
    }
}
