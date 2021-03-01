package com.leetcode.questions.design;

public class RangeSumQueryMutable {
    private int[] rangeSum, nums;

    public RangeSumQueryMutable(int[] nums) {
        this.nums = nums;
        rangeSum = new int[nums.length];

        int sumSoFar = 0;

        for (int i = 0; i < nums.length; i++) {
            rangeSum[i] = nums[i] + sumSoFar;
            sumSoFar = rangeSum[i];
        }
    }

    public void update(int i, int val) {
        int oldVal = nums[i];
        int diff = val - oldVal;
        nums[i] = val;

        while (i < rangeSum.length) {
            rangeSum[i] += diff;
            i++;
        }


    }

    public int sumRange(int i, int j) {
        return rangeSum[j] - (i == 0 ? 0 : rangeSum[i - 1]);
    }
}
