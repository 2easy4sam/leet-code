package com.leetcode.questions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2d grid map of '1's (land) and '0's (water),
 * count the number of islands.
 * An island is surrounded by water and is formed by
 * connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all
 * surrounded by water.
 */
class NumberOfIslands {
    private static char LAND = '1';
    private static final int[][] NEIGHBOURS = new int[][]{
            {-1, 0},    // N
            {0, 1},     // E
            {1, 0},     // S
            {0, -1}     // W
    };

    public int numIslands2(char[][] grid) {
        if (grid.length == 0) return 0;

        final int nRows = grid.length;
        final int nCols = grid[0].length;
        int nIslands = 0;

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {

                if (grid[i][j] == LAND) {
                    Queue<int[]> q = new LinkedList<>();

                    q.offer(new int[]{i, j});

                    while (!q.isEmpty()) {
                        int[] land = q.poll();
                        grid[land[0]][land[1]] = '0';

                        for (int[] coords : NEIGHBOURS) {
                            int row = land[0] + coords[0];
                            int col = land[1] + coords[1];

                            // off-edge, count as water
                            if (row > -1 && row < nRows &&
                                    col > -1 && col < nCols &&
                                    grid[row][col] == LAND) {
                                q.add(new int[]{row, col});
                            }
                        }
                    }

                    nIslands++;
                }
            }
        }

        return nIslands;
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;

        final int nRows = grid.length;
        final int nCols = grid[0].length;
        int nIslands = 0;

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {

                if (grid[i][j] == LAND) {
                    Queue<Integer> q = new LinkedList<>();

                    q.offer(i * nRows + j);

                    while (!q.isEmpty()) {
                        int idx = q.poll();
                        int x = idx / nRows;
                        int y = idx % nRows;
                        grid[x][y] = '0';

                        if (x - 1 > -1 && grid[x - 1][y] == LAND) {
                            q.offer((x - 1) * nRows + y);
                        }

                        if (y + 1 < nCols && grid[x][y + 1] == LAND) {
                            q.offer(x * nRows + y + 1);
                        }

                        if (x + 1 < nRows && grid[x + 1][y] == LAND) {
                            q.offer((x + 1) * nRows + y);
                        }

                        if (y - 1 > -1 && grid[x][y - 1] == LAND) {
                            q.offer(x * nRows + y - 1);
                        }
                    }

                    nIslands++;
                }
            }
        }

        return nIslands;
    }

    public int numIslands3(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfsFill(grid, i, j);
                    count++;
                }
            }
        return count;
    }

    private void bfsFill(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        int n = grid.length;
        int m = grid[0].length;
        LinkedList<Integer> queue = new LinkedList<>();
        int code = x * m + y;
        queue.offer(code);
        while (!queue.isEmpty()) {
            code = queue.poll();
            int i = code / m;
            int j = code % m;
            if (i > 0 && grid[i - 1][j] == '1') {
                //search upward and mark adjacent '1's as '0'.
                queue.offer((i - 1) * m + j);
                grid[i - 1][j] = '0';
            }
            if (i < n - 1 && grid[i + 1][j] == '1') {
                //down
                queue.offer((i + 1) * m + j);
                grid[i + 1][j] = '0';
            }
            if (j > 0 && grid[i][j - 1] == '1') {
                //left
                queue.offer(i * m + j - 1);
                grid[i][j - 1] = '0';
            }
            if (j < m - 1 && grid[i][j + 1] == '1') {
                //right
                queue.offer(i * m + j + 1);
                grid[i][j + 1] = '0';
            }
        }
    }
}
