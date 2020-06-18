package com.leetcode.questions;

public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (i > 0 && A[i] > A[i - 1] && A[i] > A[i + 1]) return i;
        }

        return -1;
    }
}
