package com.leetcode.questions.array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class AsFarFromLandAsPossible {
    private int max = 0;

    public int maxDistance(int[][] grid) {
        int[][] dirs = new int[][]{
                {-1, 0},
                {0, 1},
                {1, 0},
                {0, -1}
        };

        /*
        - BFS
        */
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) continue;
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i, j});
                Set<Integer> visited = new HashSet<>();
                int dist = 1;

                while (!q.isEmpty()) {
                    int size = 0;

                    while (size > 0) {
                        int[] coords = q.poll();
                        visited.add(to1dIdx(coords[0], coords[1], n));

                        if (grid[coords[0]][coords[1]] == 1) {
                            max = Math.max(max, dist);
                        }

                        for (int[] dir : dirs) {
                            int row = coords[0] + dir[0];
                            int col = coords[1] + dir[1];

                            if (row < 0 || row > m - 1 || col < 0 || col > n - 1 || visited.contains(to1dIdx(row, col, n)))
                                continue;

                            q.offer(new int[]{row, col});
                        }
                    }

                    dist++;
                }
            }
        }

        return max;
    }

    private int to1dIdx(int x, int y, int nCols) {
        return x * nCols + y;
    }
}
