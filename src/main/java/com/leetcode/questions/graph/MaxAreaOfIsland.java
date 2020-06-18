package com.leetcode.questions.graph;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {

    private static final int[] UP = new int[]{-1, 0};
    private static final int[] DOWN = new int[]{1, 0};
    private static final int[] LEFT = new int[]{0, -1};
    private static final int[] RIGHT = new int[]{0, 1};
    private static final int[][] DIRS = new int[][]{
            UP, DOWN, LEFT, RIGHT
    };

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0, nRows = grid.length, nCols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (grid[i][j] == 0) continue;
                q.offer(new int[]{i, j});
                grid[i][j] = 0;
                max = Math.max(max, calcArea(grid, q));
            }
        }

        return max;
    }

    private int calcArea(int[][] grid, Queue<int[]> q) {
        int area = 0;

        while (!q.isEmpty()) {
            final int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] coords = q.poll();
                area++;

                for (int[] dir : DIRS) {
                    int x = coords[0] + dir[0], y = coords[1] + dir[1];
                    if (x < 0 || x > grid.length - 1
                            || y < 0 || y > grid[0].length - 1)
                        continue;
                    if (grid[x][y] == 1) {
                        grid[x][y] = 0;
                        q.offer(new int[]{x, y});
                    }
                }
            }
        }

        return area;
    }
}
