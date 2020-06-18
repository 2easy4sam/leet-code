package com.leetcode.questions;

public class MaxIncreaseToKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int maxIncrease = 0;
        int colCount = grid[0].length;

        int[] topBottomSkyline = new int[colCount];
        int[] leftRightSkyline = new int[grid.length];

        // row
        for (int i = 0; i < grid.length; i++) {
            // col
            for (int j = 0; j < colCount; j++) {
                leftRightSkyline[i] = Math.max(leftRightSkyline[i], grid[i][j]);
                topBottomSkyline[j] = Math.max(topBottomSkyline[j], grid[i][j]);
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < colCount; j++) {
                int increase = Math.min(leftRightSkyline[i], topBottomSkyline[j]) - grid[i][j];
                maxIncrease += increase;
            }
        }

        return maxIncrease;
    }
}
