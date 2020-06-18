package com.leetcode.questions.dp;

public class TargetSum {

    private int total = 0;

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0, nZeros = 0;
        for (int num : nums) {
            if (num == 0) nZeros++;
            sum += num;
        }

        if (sum < S) return 0;

        for (int i = 0; i < nums.length; i++) {
            dfs(nums, i, S, sum);
        }

        return total + (nZeros > 0 && nZeros >= nums.length / 2 ? 1 : 0);
    }

    private void dfs(int[] nums, int idx, int S, int sum) {
        sum += (-nums[idx] * 2);
        if (sum == S) total++;
        for (int i = idx + 1; i < nums.length; i++) {
            dfs(nums, i, S, sum);
        }
    }
}
