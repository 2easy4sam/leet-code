package com.leetcode.questions.array;

public class ShuffleTheArray {
    /*
- intuition:
    - use two pointers to iterate through the elements in two partitions
        - treat the array as two arrays
*/
    public int[] shuffle(int[] nums, int n) {
        if (nums == null || nums.length == 0) return nums;

        int[] res = new int[2 * n];
        boolean isX = true;
        int i = 0, j = n, idx = 0;

        while (idx < nums.length) {
            if (isX) {
                res[idx++] = nums[i++];
                isX = false;
            } else {
                res[idx++] = nums[j++];
                isX = true;
            }
        }

        return res;
    }
}
