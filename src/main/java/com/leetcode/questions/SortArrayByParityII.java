package com.leetcode.questions;

public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int[] res = new int[A.length];

        for (int i = 0, j = -2, k = -1; i < A.length; i++) {
            res[A[i] % 2 == 0 ? (j += 2) : (k += 2)] = A[i];
        }

        return res;
    }
}
