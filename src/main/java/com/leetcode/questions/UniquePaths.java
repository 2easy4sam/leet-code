package com.leetcode.questions;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int len = m * n;

        if (len == 0) return 0;
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= len; i++) {
            if (i % m == 0) {
                dp[i] += dp[i - m];
            } else {
                dp[i] += dp[i - 1];

                if (i > m) {
                    dp[i] += dp[i - m];
                }
            }
        }

        return dp[len - 1];
    }
}
