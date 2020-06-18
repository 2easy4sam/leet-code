package com.leetcode.questions;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int rowBegin = 0, rowEnd = n - 1, colBegin = 0, colEnd = n - 1;
        int val = 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // traverse right
            for (int i = colBegin; i <= colEnd; i++) {
                matrix[rowBegin][i] = val++;
            }
            rowBegin++;

            // traverse down
            for (int i = rowBegin; i <= rowEnd; i++) {
                matrix[i][colEnd] = val++;
            }
            colEnd--;

            // traverse left
            for (int i = colEnd; i >= colBegin; i--) {
                matrix[rowEnd][i] = val++;
            }
            rowEnd--;

            // traverse up
            for (int i = rowEnd; i >= rowBegin; i--) {
                matrix[i][colBegin] = val++;
            }
            colBegin++;
        }

        return matrix;
    }
}
