package com.leetcode.questions.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CutOffTreesForGolfEvents {
    /*
- keywords/key points:
    - trees must be cut down in the descending order of their heights
    - shortest path
*/
    private int[][] dirs = new int[][]{
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public int cutOffTree(List<List<Integer>> forest) {
        // u, d, l, r
        /*
        to make sure that we cut down the trees in descending order of tree height, we could use a priorityqueue
        */
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int m = forest.size(), n = forest.get(0).size();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) pq.offer(new int[]{i, j, forest.get(i).get(j)});
            }
        }

        int[] curr = new int[2];
        int min = 0;

        while (!pq.isEmpty()) {
            int[] tree = pq.poll();
            int steps = minSteps(forest, curr, tree, m, n);
            if (steps == -1) return -1;
            min += steps;
            curr[0] = tree[0];
            curr[1] = tree[1];
        }

        return min;
    }

    private int minSteps(List<List<Integer>> forest, int[] curr, int[] dest, int m, int n) {
        boolean[][] visited = new boolean[m][n];
        visited[curr[0]][curr[1]] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(curr);

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                curr = q.poll();
                if (curr[0] == dest[0] && curr[1] == dest[1]) return steps;

                for (int[] dir : dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];

                    if (x < 0 || x == m || y < 0 || y == n || visited[x][y] || forest.get(x).get(y) == 0) continue;
                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }

            steps++;
        }

        return -1;
    }
}
