package com.leetcode.questions.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class MinMovesToMoveABoxToTheirTargetLocation {
    /*
    - we have 2 types of entities here
        - box B
        - player S
    - the goal of the game is get the box 'B' to the target location 'T'
        - to move B, S needs to stand right behind it
            - i.e if B is currently at gird[i][j], then we need to check if grid[i][j + 1] is accessible to the player if we want to move B to the west/left
    */
    public int minPushBox(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dirs = new int[][]{
                {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };
        int[] sStart = new int[2], bStart = new int[2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'B') {
                    bStart[0] = i;
                    bStart[1] = j;
                } else if (grid[i][j] == 'S') {
                    sStart[0] = i;
                    sStart[1] = j;
                }
            }
        }

        /*
        br, bc, sr, sc
        */
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{bStart[0], bStart[1], sStart[0], sStart[1]});

        boolean[][][] visited = new boolean[m][n][4];

        for (int moves = 0; !q.isEmpty(); moves++) {
            for (int size = q.size(); size > 0; size--) {
                int[] curr = q.poll();
                if (grid[curr[0]][curr[1]] == 'T') return moves;

                for (int i = 0; i < 4; i++) {
                    if (visited[curr[0]][curr[1]][i]) continue;
                    int[] dir = dirs[i];
                    int nextBr = curr[0] + dir[0], nextBc = curr[1] + dir[1];
                    if (isOutOfBounds(grid, nextBr, nextBc)) continue;
                    int nextSr = curr[0] - dir[0], nextSc = curr[1] - dir[1];
                    if (isOutOfBounds(grid, nextSr, nextSc)) continue;
                    if (!canReach(grid, curr, nextBr, nextBc)) continue;
                    visited[curr[0]][curr[1]][i] = true;
                    q.offer(new int[]{nextSr, nextSc, curr[0], curr[1]});
                }
            }
        }

        return -1;
    }

    private boolean isOutOfBounds(char[][] grid, int r, int c) {
        return r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '#';
    }

    private boolean canReach(char[][] grid, int[] curr, int tr, int tc) {
        int[][] dirs = new int[][]{
                {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[curr[0]][curr[1]] = true;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{curr[2], curr[3]});

        while (!q.isEmpty()) {
            curr = q.poll();
            if (curr[0] == tr && curr[1] == tc) return true;


            for (int[] dir : dirs) {
                int r = curr[0] + dir[0], c = curr[1] + dir[1];

                if (isOutOfBounds(grid, r, c) || visited[r][c]) continue;
                visited[r][c] = true;
                q.offer(new int[]{r, c});
            }
        }

        return false;
    }
}
