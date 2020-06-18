package com.leetcode.questions;

public class FixedPoint {
    public int solve(int[] A) {
        int ans = -1;

        for (int i = 0; i < A.length; i++) {
            if (i == A[i]) ans = A[i];
        }

        return ans;
    }
}
