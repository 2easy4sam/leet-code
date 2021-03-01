package com.leetcode.questions.design;

import java.util.HashSet;
import java.util.Set;

public class SnakeGame {
    /**
     * Initialize your data structure here.
     */
    public static class Snake {
        int[] coords;
        Snake next;

        Snake(int x, int y) {
            coords = new int[]{x, y};
        }
    }

    private Snake head;
    private int score;
    private final int nRows, nCols;
    private int[][] food;
    private int foodIdx;

    public SnakeGame(int width, int height, int[][] food) {
        nRows = height;
        nCols = width;
        score = 0;
        foodIdx = 0;
        head = new Snake(0, 0);

        this.food = food;
    }

    /**
     * Moves the snake.
     */
    public int move(String dir) {
        Snake curr = head, prev = null;
        Set<Integer> set = new HashSet<>();
        // the direction of the previous node before it changed its direction
        int oldX = -1, oldY = -1, oldScore = score;

        while (curr != null) {
            if (oldX != -1 && oldY != -1) {
                int xDiff = oldX - curr.coords[0];
                int yDiff = oldY - curr.coords[1];

                if (xDiff == 1) {
                    dir = "D";
                } else if (xDiff == -1) {
                    dir = "U";
                } else if (yDiff == 1) {
                    dir = "R";
                } else if (yDiff == -1) {
                    dir = "L";
                }
            }

            int newX = curr.coords[0];
            int newY = curr.coords[1];

            if (dir.equals("U")) {
                newX--;
            } else if (dir.equals("R")) {
                newY++;
            } else if (dir.equals("D")) {
                newX++;
            } else {
                // L
                newY--;
            }

            if (!isWithinBounds(newX, newY) || !set.add(to2DIdx(newX, newY))) return -1;

            if (prev == null && foodIdx < food.length && food[foodIdx][0] == newX && food[foodIdx][1] == newY) {
                score++;
                foodIdx++;
            }

            oldX = curr.coords[0];
            oldY = curr.coords[1];
            curr.coords[0] = newX;
            curr.coords[1] = newY;

            prev = curr;
            curr = curr.next;
        }

        if (score > oldScore) {
            prev.next = new Snake(oldX, oldY);
        }

        return score;
    }

    private int to2DIdx(int x, int y) {
        return x * nCols + y;
    }

    private boolean isWithinBounds(int x, int y) {
        return x >= 0 && y >= 0 && x < nRows && y < nCols;
    }
}
