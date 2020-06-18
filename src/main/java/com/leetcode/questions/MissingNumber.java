package com.leetcode.questions;

import java.util.Arrays;

public class MissingNumber {
    public int missingNumber2(int[] nums) {
        int sum = 0, largest = 0;

        for (int num : nums) {
            if (num > largest) largest = num;
            sum += num;
        }

        if (largest == nums.length - 1) {
            return nums.length;
        } else {
            return largest * (nums.length + 1) / 2 - sum;
        }
    }

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }

        return nums.length;
    }
}
