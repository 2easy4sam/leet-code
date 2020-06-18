package com.leetcode.questions;

public class ClimbingStairs {
    public int climbStairs2(int n) {
        if (n <= 3) return n;

        int prev = 2, res = 3;

        for (int i = 3; i < n; i++) {
            int sum = prev + res;
            prev = res;
            res = sum;
        }

        return res;
    }

    public int climbStairs(int n) {
        if (n <= 3) return n;
        return climbStairs(n - 2) + climbStairs(n - 1);
    }

    public int climbStairsDP(int n) {
        int[] numbers = new int[n + 1];
        return climbStairsDP(n, numbers);
    }

    private int climbStairsDP(int n, int[] numbers) {
        if (n <= 3) return n;
        if (numbers[n] != 0) {
            return numbers[n];
        }
        numbers[n] = climbStairsDP(n - 2, numbers) + climbStairsDP(n - 1, numbers);
        return numbers[n];
    }
}
