package com.leetcode.questions;

public class FlippingAndInvertImage {

    public int[][] flipAndInvertImage(int[][] A) {

        int len = A.length;
        int[][] res = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                res[i][len - j - 1] = 1 - A[i][j];
            }
        }

        return res;
    }
}
