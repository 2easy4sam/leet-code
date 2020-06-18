package com.leetcode.questions;

public class Tribonacci {

    int tribonacciRecursive(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        return tribonacciRecursive(n - 3) + tribonacciRecursive(n - 2) + tribonacciRecursive(n - 1);
    }

    int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = dp[2] = 1;

        return tribonacci(n, dp);
    }

    private int tribonacci(int n, int[] dp) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        if (dp[n] != 0) return dp[n];
        int res = tribonacci(n - 3, dp) + tribonacci(n - 2, dp) + tribonacci(n - 1, dp);
        dp[n] = res;
        return res;
    }
}
