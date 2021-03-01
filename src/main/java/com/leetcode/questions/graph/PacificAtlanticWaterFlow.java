package com.leetcode.questions.graph;

import java.util.*;

public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        /*
        [0][0] -> 1
            - [0][1] -> 2
            - [1][0] -> 3
        thus it cannot travel right OR down, so it cannot reach Atlantic
        */
        int m = matrix.length, n = matrix[0].length;

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachPacificAtlantic(matrix, i, j))
                    res.add(Arrays.asList(i, j));
            }
        }

        return res;
    }

    private boolean canReachPacificAtlantic(int[][] matrix, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        boolean canReachPacific = false, canReachAtlantic = false;
        q.offer(new int[]{x, y});
        visited.add(to1dIdx(x, y, matrix[0].length));

        while (!q.isEmpty()) {
            int n = q.size();

            while (n != 0) {
                int[] coords = q.poll();
                if (coords[0] == 0 || coords[1] == 0)
                    canReachPacific = true;
                if (coords[0] == matrix.length - 1 || coords[1] == matrix[0].length - 1) {
                    canReachAtlantic = true;
                }

                if (canReachPacific && canReachAtlantic) break;

                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i == j) continue;
                        x = coords[0] + i;
                        y = coords[1] + j;

                        if (x < 0 || x > matrix.length - 1 || y < 0 || y > matrix[0].length - 1 || matrix[x][y] > matrix[coords[0]][coords[1]])
                            continue;
                        int idx = to1dIdx(x, y, matrix[0].length);
                        if (!visited.contains(idx)) {
                            q.offer(new int[]{x, y});
                            visited.add(idx);
                        }
                    }
                }
                n--;
            }
        }

        return canReachPacific && canReachAtlantic;
    }

    private int to1dIdx(int x, int y, int nCols) {
        return x * nCols + y;
    }
}
