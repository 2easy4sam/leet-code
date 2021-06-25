package com.leetcode.questions.array;

public class FormArrByConcatenatingSubArrsOrAnotherArr {
    public boolean canChoose(int[][] groups, int[] nums) {
        int idx = 0, n = nums.length;

        for (int[] group : groups) {
            int i = 0;

            while (idx < n && i < group.length) {
                if (group[i] == nums[idx]) {
                    i++;
                } else {
                    i = 0;
                    if (group[i] == nums[idx]) i++;
                }

                idx++;
            }

            if (i != group.length) return false;
        }

        return true;
    }
}
