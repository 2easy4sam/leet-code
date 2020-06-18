package com.leetcode.questions;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;

        int sumSoFar = nums[0], maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int sum = nums[i] + sumSoFar;
            sumSoFar = sum < nums[i] ? nums[i] : sum;
            maxSoFar = Math.max(maxSoFar, sumSoFar);
        }

        return maxSoFar;
    }
}
