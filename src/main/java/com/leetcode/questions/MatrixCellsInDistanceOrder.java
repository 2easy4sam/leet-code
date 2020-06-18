package com.leetcode.questions;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixCellsInDistanceOrder {
    private static final int[][] NEIGHBOUR_COORDS = new int[][]{
            {-1, 0},    // N
            {0, 1},        // E
            {1, 0},        // S
            {0, -1}        // W
    };

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        boolean[][] visited = new boolean[R][C];
        int[] closest = new int[]{r0, c0};
        int[][] res = new int[R * C][2];
        visited[r0][c0] = true;

        Queue<int[]> q = new LinkedList();
        q.add(closest);
        int i = 0;

        while (!q.isEmpty()) {
            int[] head = q.poll();
            res[i++] = head;

            for (int[] coords : NEIGHBOUR_COORDS) {
                int row = head[0] + coords[0];
                int col = head[1] + coords[1];

                if (row > -1 && row < R && col > -1 && col < C && !visited[row][col]) {
                    visited[row][col] = true;
                    q.add(new int[]{row, col});
                }
            }
        }

        return res;
    }
}
