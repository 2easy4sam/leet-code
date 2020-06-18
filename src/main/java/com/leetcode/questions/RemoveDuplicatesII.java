package com.leetcode.questions;

/**
 * Similar to RemoveDuplicates, except that each int is allowed to appear at most twice,
 * i.e. [1,1,1,2,2,2,3] -> [1,1,2,2,3]
 * Where a digit occurs more than once, two instances should be kept in the result
 */
class RemoveDuplicatesII {
    int removeDuplicates(int[] nums) {
        int len = nums.length;

        if (len == 0) return 0;
        int count = 0, j = 0, val = nums[0];

        for (int i = 0; i < len; i++) {
            if (nums[i] == val) {
                count++;
                if (count == 2) nums[j + 1] = nums[i];
                if (i == len - 1 && j < len - 1) nums[++j] = nums[i];
            } else {
                j += count > 1 ? 2 : 1;
                nums[j] = nums[i];
                val = nums[i];
                count = 1;
            }
        }

        return j + 1;
    }

    // note that this can be generalised to any k number of duplicates
    int removeDuplicates2(int[] nums) {
        int i = 0;

        for (int num : nums) {
            if (i < 2 || num > nums[i - 2]) {
                nums[i] = num;
                i++;
            }
        }

        return i;
    }
}
