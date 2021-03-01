package com.leetcode.questions.array;

public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        int nRows = Math.min(A.length, B.length), nCols = B.length;
        int[][] mat = new int[nRows][nCols];

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                int dp = 0;

                for (int k = 0; k < nCols; k++) {
                    dp += (A[i][k] * B[j][k]);
                }

                mat[i][j] = dp;
            }
        }

        return mat;
    }
}
