package com.leetcode.questions.bfs;

import java.util.*;

public class MinCostToMakeAtLeastOneValidPathInGrid {
    /*
    - at each iteration, we can choose all 4 neighbouring cells to advance to
    */
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] dirs = new int[][]{
                {0, 1},     // right
                {0, -1},    // left
                {1, 0},     // down
                {-1, 0}     // up
        };

        int[][] cost = new int[m][n];

        for (int i = 0; i < cost.length; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);
        cost[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int x = top[0], y = top[1], currCost = top[2];

            for (int i = 0; i < dirs.length; i++) {
                int[] dir = dirs[i];
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx == m || ny < 0 || ny == n) continue;
                int newCost = currCost;
                if (i + 1 != grid[x][y]) newCost++;
                if (cost[nx][ny] > newCost) {
                    cost[nx][ny] = newCost;
                    pq.offer(new int[]{nx, ny, newCost});
                }
            }
        }

        return cost[m - 1][n - 1];
    }
}
