package com.leetcode.questions.dp;

public class NumMatrix {
    private int[][] dp, mat;
    private int nRows, nCols;

    public NumMatrix(int[][] matrix) {
        nRows = matrix.length;
        nCols = matrix[0].length;
        dp = new int[nRows + 1][nCols + 1];
        mat = matrix;
        cache();
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }

    private void cache() {
        int row = 0, col = 0;

        while (row < nRows && col < nCols) {
            int i = row, j = col;

            while (j < nCols) {
                dp[i + 1][j + 1] = dp[i + 1][j] - dp[i][j] + dp[i][j + 1] + mat[i][j];
                j++;
            }

            j = col;
            while (i < nRows) {
                dp[i + 1][j + 1] = dp[i + 1][j] - dp[i][j] + dp[i][j + 1] + mat[i][j];
                i++;
            }

            row++;
            col++;
        }
    }

}
