package com.leetcode.questions.array;

import java.util.Arrays;

public class ThreeSumSmaller {

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length, cnt = 0;

        for (int i = 0; i < n - 2; i++) {
            int j = i + 1, k = n - 1;

            while (j < k && nums[i] + nums[j] + nums[k] >= target) {
                k--;
            }

            // at this point, sum may still be greater than or equal to target
            // if that is the case, it means k == j
            if (k > j) {
                cnt += (k - j);
            }

            j++;
            while (j < k && nums[i] + nums[j] + nums[k] < target) {
                cnt += (k - j);
                j++;
            }
        }

        return cnt;
    }
}
