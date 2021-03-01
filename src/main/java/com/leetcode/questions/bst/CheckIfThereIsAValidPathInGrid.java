package com.leetcode.questions.bst;

import java.util.*;

public class CheckIfThereIsAValidPathInGrid {
    public boolean hasValidPath(int[][] grid) {
        int[][] dirs = new int[][]{
                {-1, 0},    // north 0
                {1, 0},     // south 1
                {0, -1},    // west 2
                {0, 1}      // east 3
        };

        Map<Integer, Map<Integer, Set<Integer>>> map = new HashMap<>();
        Map<Integer, Set<Integer>> northMap = new HashMap<>();
        northMap.put(2, Set.of(2, 3, 4));
        northMap.put(5, Set.of(2, 3, 4));
        northMap.put(6, Set.of(2, 3, 4));
        map.put(0, northMap);

        Map<Integer, Set<Integer>> southMap = new HashMap<>();
        southMap.put(2, Set.of(2, 5, 6));
        southMap.put(3, Set.of(2, 5, 6));
        southMap.put(4, Set.of(2, 5, 6));
        map.put(1, southMap);

        Map<Integer, Set<Integer>> westMap = new HashMap<>();
        westMap.put(1, Set.of(1, 4, 6));
        westMap.put(3, Set.of(1, 4, 6));
        westMap.put(5, Set.of(1, 4, 6));
        map.put(2, westMap);

        Map<Integer, Set<Integer>> eastMap = new HashMap<>();
        eastMap.put(1, Set.of(1, 3, 5));
        eastMap.put(4, Set.of(1, 3, 5));
        eastMap.put(6, Set.of(1, 3, 5));
        map.put(3, eastMap);

        int m = grid.length, n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] coords = q.poll();
                if (coords[0] == m - 1 && coords[1] == n - 1) return true;
                int val = grid[coords[0]][coords[1]];

                for (int i = 0; i < dirs.length; i++) {
                    /*
                    IF 1
                    THEN [w, e]

                    IF 2
                    THEN [n, s]

                    IF 3
                    THEN [w, s]

                    IF 4
                    THEN [e, s]

                    IF 5
                    THEN [n, w]

                    IF 6
                    THEN [n, e]
                    */
                    int[] dir = dirs[i];

                    // going north
                    if (dir[0] == -1 && val != 2 && val != 5 && val != 6) continue;
                    // going south
                    if (dir[0] == 1 && val != 2 && val != 3 && val != 4) continue;
                    // going west
                    if (dir[1] == -1 && val != 1 && val != 3 && val != 5) continue;
                    // going east
                    if (dir[1] == 1 && val != 1 && val != 4 && val != 6) continue;

                    int x = coords[0] + dir[0];
                    int y = coords[1] + dir[1];

                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]
                            && map.get(i).containsKey(val) && map.get(i).get(val).contains(grid[x][y])) {
                        q.offer(new int[]{x, y});
                    }
                }

                visited[coords[0]][coords[1]] = true;
            }
        }

        return false;
    }
}
