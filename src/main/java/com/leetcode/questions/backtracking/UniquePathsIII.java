package com.leetcode.questions.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniquePathsIII {
    private static final int START = 1;
    private static final int END = 2;
    private static final int WALL = -1;

    private Set<List<Integer>> paths;

    public int uniquePathsIII(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        paths = new HashSet<>();

        int n = 0, nRows = grid.length, nCols = grid[0].length;
        int[] start = new int[2];

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                int cell = grid[i][j];
                if (cell == START) {
                    start[0] = i;
                    start[1] = j;
                }
                if (cell != WALL) {
                    n++;
                }
            }
        }

        dfs(grid, start[0], start[1], n, new ArrayList<>());

        return paths.size();
    }

    /*
    1. dfs
    2. mark current cell as visited (obstacle) and build path as we go
    3. if current cell is off-edge/obstacle return
    4. if current cell is end
        4.1. check if the path contains a total of n empty cells
    */

    private void dfs(int[][] grid, int i, int j, int n, List<Integer> path) {
        if (i < 0 || i > grid.length - 1
                || j < 0 || j > grid[0].length - 1
                || grid[i][j] == WALL) return;
        // valid cell, add it to path
        path.add(get1dIdx(i, j, grid[0].length));
        if (grid[i][j] == END) {
            if (path.size() == n) paths.add(path);
            return;
        }

        // mark it as visited/obstacle
        int tmp = grid[i][j];
        grid[i][j] = WALL;

        dfs(grid, i - 1, j, n, new ArrayList<>(path));
        dfs(grid, i, j + 1, n, new ArrayList<>(path));
        dfs(grid, i + 1, j, n, new ArrayList<>(path));
        dfs(grid, i, j - 1, n, new ArrayList<>(path));

        grid[i][j] = tmp;
    }

    private int get1dIdx(int i, int j, int nCols) {
        return i * nCols + j;
    }
}
