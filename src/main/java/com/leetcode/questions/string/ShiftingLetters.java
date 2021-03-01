package com.leetcode.questions.string;

public class ShiftingLetters {
    public String shiftingLetters(String S, int[] shifts) {
        if (S == null || S.isEmpty()) return "";
        int n = shifts.length, runningSum = 0;

        for (int i = n - 1; i >= 0; i--) {
            runningSum += (shifts[i] % 26);
            shifts[i] = runningSum;
        }

        char[] chars = S.toCharArray();

        for (int i = 0; i < S.length() && i < n; i++) {
            char c = chars[i];
            chars[i] = (char) ((c - 'a' + shifts[i]) % 26 + 'a');
        }

        return new String(chars, 0, Math.min(n, S.length()));
    }
}