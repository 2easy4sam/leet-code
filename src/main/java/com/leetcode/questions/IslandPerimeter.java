package com.leetcode.questions;

public class IslandPerimeter {
    private static final int LAND = 1;
    private static final int[][] NEIGHBOUR_COORDS = new int[][]{
            {-1, 0},    // N
            {0, 1},     // E
            {1, 0},     // S
            {0, -1}     // W
    };

    public int islandPerimeter(int[][] grid) {
        final int rowCount = grid.length;
        final int colCount = grid[0].length;

        int perimeter = 0;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                int cell = grid[i][j];

                if (cell == LAND) {
                    for (int[] coords : NEIGHBOUR_COORDS) {
                        int row = i + coords[0];
                        int col = j + coords[1];

                        if (row >= 0 && row < rowCount && col >= 0 && col < colCount) {
                            if (grid[row][col] != LAND) perimeter++;
                        } else {
                            if (row < 0 || row == rowCount) {
                                perimeter++;
                            }
                            if (col < 0 || col == colCount) {
                                perimeter++;
                            }
                        }
                    }
                }
            }
        }

        return perimeter;
    }
}
