package com.leetcode.questions.dp;

/*
Given a m x n grid filled with non-negative numbers,
find a path from top left to bottom right which minimizes the sum of
all numbers along its path.

Note: You can only move either down or right at any point in time.
*/
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        /*
        since we can only go either right or down
        which means that a cell can be visited 2 times max.
        other cells will be visited 1 time only
        those that are visited once and once only, we can store
        the accumulated sum in the cell itself
        */
        int nRows = grid.length, nCols = grid[0].length;

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                int val = grid[i][j];
                if (i == 0 && j == 0) continue;
                if (i == 0) val += grid[i][j - 1];
                else if (j == 0) val += grid[i - 1][j];
                else val += Math.min(grid[i - 1][j], grid[i][j - 1]);
                grid[i][j] = val;
            }
        }

        return grid[nRows - 1][nCols - 1];
    }
}
