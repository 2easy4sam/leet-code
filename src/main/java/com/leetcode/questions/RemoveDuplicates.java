package com.leetcode.questions;

class RemoveDuplicates {
    int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int shift = 0, val = nums[0], len = nums.length;

        for (int i = 0; i < len; i++) {

            if (nums[i] != val) {
                nums[i - shift] = nums[i];
                val = nums[i];
            } else {
                if (i != 0) shift++;
            }
        }

        return len - shift;
    }

    int removeDuplicates2(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;

        int j = 0, val = nums[0];

        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                nums[++j] = nums[i];
                val = nums[i];
            }
        }

        return j + 1;
    }
}
