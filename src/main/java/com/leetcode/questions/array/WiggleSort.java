package com.leetcode.questions.array;

public class WiggleSort {
    /*
    1. find max -> min -> max ... between i and j
    2. iteratively reduce j, which is initialized to n - 1, until j == 0
    */
    public void wiggleSort(int[] nums) {
        boolean findMax = true;
        int n = nums.length, j = n - 1;

        while (j != 0) {
            int idx = findMax
                    ? findMax(nums, j)
                    : findMin(nums, j);

            if (idx != j) swap(nums, idx, j);
            findMax = !findMax;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private int findMin(int[] nums, int j) {
        int min = Integer.MAX_VALUE, idx = 0, i = 0;

        while (i <= j) {
            if (nums[i] < min) {
                min = nums[i];
                idx = i;
            }
            i++;
        }

        return idx;
    }

    private int findMax(int[] nums, int j) {
        int max = Integer.MIN_VALUE, idx = 0, i = 0;

        while (i <= j) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
            i++;
        }

        return idx;
    }

    public void wiggleSort2(int[] nums) {
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            if ((i % 2 == 1) == (nums[i] < nums[i - 1])) {
                swap(nums, i - 1, i);
            }
        }
    }
}
