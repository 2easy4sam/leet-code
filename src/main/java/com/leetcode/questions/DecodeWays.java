package com.leetcode.questions;

public class DecodeWays {
    public int numDecodings(String s) {
        final int n = s.length();
        if (n == 0) return 0;

        int[] dp = new int[n + 1];
        dp[0] = 1;  // since n = 2 would have 1 + 1 = 2 combos
        dp[1] = s.startsWith("0") ? 0 : 1;  // n = 1 -> 1

        for (int i = 2; i <= n; i++) {
            int a = s.charAt(i - 2) - '0';
            int b = s.charAt(i - 1) - '0';
            int ab = a * 10 + b;

            if (b != 0) {
                dp[i] += dp[i - 1];
            }
            if (ab > 9 && ab < 27) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
