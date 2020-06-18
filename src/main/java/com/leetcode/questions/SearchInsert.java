package com.leetcode.questions;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int i;

        for (i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == target || target < num) return i;
        }

        return i;
    }
}
