package com.leetcode.questions.array;

import java.util.Arrays;

public class DivideArrInSetsOfKConsecutiveNums {

    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0) return false;
        Arrays.sort(nums);

        int i = 0;

        while (i < n - 1) {
            if ((i + 1) % k == 0) {
                Arrays.sort(nums, i + 1, n);
                i++;
                continue;
            }

            int ith = nums[i];
            int next = ith + 1;

            int j = i + 1;

            while (j < n && nums[j] != next) j++;
            if (j == n) return false;

            int tmp = nums[i + 1];
            nums[i + 1] = nums[j];
            nums[j] = tmp;


            i++;
        }

        return true;
    }
}
