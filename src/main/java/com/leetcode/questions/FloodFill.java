package com.leetcode.questions;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    private static final int[][] NEIGHBOUR_COORDS = new int[][]{
            {-1, 0},    // N
            {0, 1},     // E
            {1, 0},     // S
            {0, -1}     // W
    };

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        final int color = image[sr][sc];
        final int nRows = image.length;
        final int nCols = image[0].length;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(sr * nRows + sc);

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            int row = idx / nRows;
            int col = idx % nRows;
            image[row][col] = newColor;

            for (int[] coords : NEIGHBOUR_COORDS) {
                int newRow = row;
                int newCol = col;

                while (newRow + coords[0] >= 0 && newRow + coords[0] < nRows &&
                        newCol + coords[1] >= 0 && newCol + coords[1] < nCols &&
                        image[newRow + coords[0]][newCol + coords[1]] == color) {
                    newRow += coords[0];
                    newCol += coords[1];
                    stack.push(newRow * nRows + newCol);
                }
            }
        }

        return image;
    }

    public int[][] floodFillBFS(int[][] image, int sr, int sc, int newColor) {
        final int color = image[sr][sc];
        final int nRows = image.length;
        final int nCols = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});

        while (!queue.isEmpty()) {
            int[] top = queue.remove();
            int row = top[0];
            int col = top[1];
            image[row][col] = newColor;

            for (int[] coords : NEIGHBOUR_COORDS) {

                if (top[0] + coords[0] >= 0 && top[0] + coords[0] < nRows &&
                        top[1] + coords[1] >= 0 && top[1] + coords[1] < nCols &&
                        image[top[0] + coords[0]][top[1] + coords[1]] == color) {
                    queue.add(new int[]{top[0] + coords[0], top[1] + coords[1]});
                }
            }
        }

        return image;
    }

    public int[][] floodFill3(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
    }
}
