package com.leetcode.questions.dp;

public class MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        /*
        IF we had a 1*1 matrix i.e. a single cell, the block sum would be the value of that cell
        IF we expand the matrix and have a 2*2 matrix, the block sum would be the sum
        +-+-+
        |1|2|
        +-+-+
        |3|?|
        +-+-+
        suppose 2 is the block sum of   mat[0][0] + mat[0][1]
        and 3 is the block sum of       mat[0][0] + mat[1][0]
        ? = 2 + 3 - 1 + the value in ?
        */

        int m = mat.length, n = mat[0].length;
        int[][] blockSum = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                blockSum[i + 1][j + 1] = blockSum[i + 1][j] + blockSum[i][j + 1] - blockSum[i][j] + mat[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(0, i - K - 1), r2 = Math.min(m - 1, i + K);
                int c1 = Math.max(0, j - K - 1), c2 = Math.min(n - 1, j + K);
                mat[i][j] = blockSum[r2][c2] - blockSum[r1][c2] - blockSum[r2][c1] + blockSum[r1][c1];
            }
        }

        return mat;
    }
}
