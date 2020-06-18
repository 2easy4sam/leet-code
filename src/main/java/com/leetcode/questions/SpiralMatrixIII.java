package com.leetcode.questions;

public class SpiralMatrixIII {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int nGrids = R * C;
        int idx = 1;
        int rowBegin = r0, rowEnd = r0 + 1, colBegin = c0, colEnd = c0 + 1;
        int[][] coords = new int[nGrids][2];
        coords[0] = new int[]{r0, c0};

        while (idx < nGrids) {
            // traverse right
            for (int j = colBegin + 1; j <= colEnd; j++) {
                if (rowBegin >= 0 && rowBegin < R && j >= 0 && j < C) {
                    coords[idx++] = new int[]{rowBegin, j};
                }
            }
            colBegin--;

            // traverse down
            for (int i = rowBegin + 1; i <= rowEnd; i++) {
                if (i >= 0 && i < R && colEnd >= 0 && colEnd < C) {
                    coords[idx++] = new int[]{i, colEnd};
                }
            }
            rowBegin--;

            // traverse left
            for (int j = colEnd - 1; j >= colBegin; j--) {
                if (rowEnd >= 0 && rowEnd < R && j >= 0 && j < C) {
                    coords[idx++] = new int[]{rowEnd, j};
                }
            }
            colEnd++;

            // traverse up
            for (int i = rowEnd - 1; i >= rowBegin; i--) {
                if (i >= 0 && i < R && colBegin >= 0 && colBegin < C) {
                    coords[idx++] = new int[]{i, colBegin};
                }
            }
            rowEnd++;
        }

        return coords;
    }
}
