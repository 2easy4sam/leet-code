package com.leetcode.questions;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    private static final int[][] TRAVERSAL_COORDS = new int[][]{
            {0, 1},     // east
            {1, 0},     // south
            {0, -1},    // west
            {-1, 0}     // north
    };

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new ArrayList<>();

        int m = matrix.length, n = matrix[0].length, size = m * n;
        int dir = 0;
        boolean[][] visited = new boolean[m][n];
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (result.size() != size) {
            if (!visited[i][j]) {
                result.add(matrix[i][j]);
                visited[i][j] = true;
            }

            int row = TRAVERSAL_COORDS[dir][0] + i;
            int col = TRAVERSAL_COORDS[dir][1] + j;

            if ((dir == 0 && col < n || dir == 2 && col >= 0) && !visited[row][col]) {
                j = col;
            } else if ((dir == 1 && row < m || dir == 3 && row >= 0) && !visited[row][col]) {
                i = row;
            } else dir = (dir + 1) % 4;
        }

        return result;
    }
}
