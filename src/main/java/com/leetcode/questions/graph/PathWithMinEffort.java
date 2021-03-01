package com.leetcode.questions.graph;

public class PathWithMinEffort {
    /*
    - intuition:
        - we could brute-force by trying out all possible routes and record the minimum along the way, but this would be too costly
        - instead, we could work out the min and max diffs by iterating over the matrix and work out
            - abs(heights[i][j] - heights[i + 1][j])
            - abs(heights[i][j] - heights[i][j + 1])
        - use bs to find out the min threshold that allows us to go from [0,0] to [m,n]
    */
    public int minimumEffortPath(int[][] heights) {
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        int nRows = heights.length, nCols = heights[0].length;

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (j < nCols - 1) {
                    // calc right diff
                    int diff = Math.abs(heights[i][j] - heights[i][j + 1]);
                    l = Math.min(l, diff);
                    r = Math.max(r, diff);
                }

                if (i < nRows - 1) {
                    int diff = Math.abs(heights[i][j] - heights[i + 1][j]);
                    l = Math.min(l, diff);
                    r = Math.max(r, diff);
                }
            }
        }

        int min = r;

        while (l <= r) {
            int k = l + (r - l) / 2;

            if (dfs(heights, new boolean[nRows][nCols], k, 0, 0)) {
                min = Math.min(min, k);
                r = k - 1;
            } else {
                l = k + 1;
            }
        }

        return Math.max(0, min);
    }

    private boolean dfs(int[][] heights, boolean[][] visited, int k, int x, int y) {
        // boundary checks
        if (x < 0 || x >= heights.length || y < 0 || y >= heights[0].length || visited[x][y]) return false;
        if (x == heights.length - 1 && y == heights[0].length - 1) return true;
        visited[x][y] = true;

        // check the diff in all 4 directions in the order of: right, down, left, up
        // only advance in one direction if and only if the abs diff is less than or equal to k
        int h = heights[x][y];

        if (y + 1 < heights[0].length && Math.abs(h - heights[x][y + 1]) <= k) {
            if (dfs(heights, visited, k, x, y + 1)) return true;
        }

        if (x + 1 < heights.length && Math.abs(h - heights[x + 1][y]) <= k) {
            if (dfs(heights, visited, k, x + 1, y)) return true;
        }

        if (y - 1 >= 0 && Math.abs(h - heights[x][y - 1]) <= k) {
            if (dfs(heights, visited, k, x, y - 1)) return true;
        }

        if (x - 1 >= 0 && Math.abs(h - heights[x - 1][y]) <= k) {
            if (dfs(heights, visited, k, x - 1, y)) return true;
        }

        return false;
    }
}
