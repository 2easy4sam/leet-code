package com.leetcode.questions.backtracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PathWithMaxGold {

    private static final int[][] NEIGHBOURS = new int[][]{
            {-1, 0},    // up
            {0, 1},     // right
            {1, 0},     // down
            {0, -1}     // left
    };

    private int max = 0;

    public int getMaximumGold(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // initialize queue with valid starting cells
        Queue<Path> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];

                if (val != 0) {
                    Path path = new Path(i, j, val);
                    path.visited.add(get1DIdx(i, j, n));
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Path path = q.poll();

                for (int[] neighbour : NEIGHBOURS) {
                    int x = path.x + neighbour[0];
                    int y = path.y + neighbour[1];

                    // off-grid check
                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    // visited check
                    if (path.visited.contains(get1DIdx(x, y, n)))
                        continue;
                    // neighbour cell value not 0
                    if (grid[x][y] == 0) continue;
                    Path newPath = new Path(x, y, path.gold + grid[x][y]);
                    newPath.visited.addAll(path.visited);
                    newPath.visited.add(get1DIdx(x, y, n));
                }

                max = Math.max(max, path.gold);
            }
        }

        return max;
    }

    private int get1DIdx(int x, int y, int n) {
        return x * n + y;
    }

    private static class Path {
        int x, y;
        int gold;
        Set<Integer> visited;

        Path(int x, int y, int gold) {
            this.x = x;
            this.y = y;
            this.gold = gold;
            visited = new HashSet<>();
        }
    }
}
