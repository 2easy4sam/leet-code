package com.leetcode.questions.dfs;

import java.util.Arrays;

public class OutOfBoundaryPaths576 {
    private int mod = (int) 1e9 + 7;

    public int findPaths(int m, int n, int N, int r, int c) {
        // up, down, left, right
        int[][] dirs = new int[][]{
                {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

        int[][][] mem = new int[m][n][N + 1];

        for (int[][] row : mem) {
            for (int[] dep : row) Arrays.fill(dep, -1);
        }

        return dfs(mem, dirs, m, n, N, r, c);
    }

    private int dfs(int[][][] mem, int[][] dirs, int m, int n, int N, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) return 1;
        if (N == 0) return 0;
        if (mem[i][j][N] != -1) return mem[i][j][N];

        int cnt = 0;

        for (int[] dir : dirs) {
            int r = i + dir[0], c = j + dir[1];
            cnt = (cnt + dfs(mem, dirs, m, n, N - 1, r, c)) % mod;
        }

        return mem[i][j][N] = cnt;
    }
}
