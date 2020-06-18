package com.leetcode.questions;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int len = A.length, i = 0, j = len - 1;
        int[] res = new int[len];

        for (int k = 0; k < len; k++) {
            int val = A[k];

            if (val % 2 == 0) {
                res[i++] = val;
            } else {
                res[j--] = val;
            }
        }

        return res;
    }
}
