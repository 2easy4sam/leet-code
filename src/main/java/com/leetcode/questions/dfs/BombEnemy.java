package com.leetcode.questions.dfs;

public class BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        int max = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    int cnt = 0;
                    cnt += dfs(grid, new int[]{-1, 0}, i, j);
                    cnt += dfs(grid, new int[]{0, 1}, i, j);
                    cnt += dfs(grid, new int[]{1, 0}, i, j);
                    cnt += dfs(grid, new int[]{0, -1}, i, j);
                    max = Math.max(max, cnt);
                }
            }
        }

        return max;
    }

    private int dfs(char[][] grid, int[] dir, int x, int y) {
        if (x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1 || grid[x][y] == 'W')
            return 0;

        int cnt = 0;
        if (grid[x][y] == 'E') cnt++;
        cnt += dfs(grid, dir, x + dir[0], y + dir[1]);

        return cnt;
    }
}
