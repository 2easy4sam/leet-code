package com.leetcode.questions.array;

import java.util.Arrays;

public class TwoSum5 {
    public int twoSum5(int[] nums, int target) {
        // write your code here
        Arrays.sort(nums);

        int cnt = 0;

        for (int l = 0; l < nums.length; l++) {
            int r = nums.length - 1;

            while (l < r) {
                if (nums[l] + nums[r] <= target) cnt++;
                r--;
            }
        }

        return cnt;
    }
}
