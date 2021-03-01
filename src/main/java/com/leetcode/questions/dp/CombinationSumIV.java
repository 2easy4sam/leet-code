package com.leetcode.questions.dp;

import java.util.Arrays;

public class CombinationSumIV {
    /*
    - keywords:
        - positive numbers, i.e. nums[i] >= 1
        - no dups, i.e. every nums[i] is unique
    - intuition:
        - combo[target] = sum(combo[target - nums[i]])
    */
    private int[] dp;

    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;

        dfs(nums, target);

        return dp[target];
    }

    private int dfs(int[] nums, int target) {
        if (dp[target] != -1) return dp[target];

        if (target == 0) {
            return 1;
        }

        int cnt = 0;

        for (int num : nums) {
            if (target >= num) {
                cnt += dfs(nums, target - num);
            }
        }

        dp[target] = cnt;

        return cnt;
    }
}
