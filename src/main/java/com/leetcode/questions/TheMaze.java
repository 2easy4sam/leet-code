package com.leetcode.questions;

import java.util.HashSet;
import java.util.Set;

public class TheMaze {
    private static final int[] UP = new int[]{-1, 0};
    private static final int[] DOWN = new int[]{1, 0};
    private static final int[] LEFT = new int[]{0, -1};
    private static final int[] RIGHT = new int[]{0, 1};
    private static final int[][] DIRS = new int[][]{
            UP, DOWN, LEFT, RIGHT
    };

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // try out different directions, record paths traversed
        for (int[] dir : DIRS) {
            Set<Integer> path = new HashSet<>();
            if (hasPath(maze, start, destination, dir, path)) return true;
        }

        return false;
    }

    private boolean hasPath(int[][] maze, int[] coords, int[] dest, int[] dir, Set<Integer> path) {
        while (canMove(maze, coords, dir, path)) {
            int x = coords[0] + dir[0], y = coords[1] + dir[1];
            if (x == dest[0] && y == dest[1]) return true;

            path.add(to1dIndex(x, y, maze[0].length));
            coords[0] = x; coords[1] = y;
        }

        // dead-end reached
        for (int[] newDir : DIRS) {
            if (newDir[0] == dir[0] && newDir[1] == dir[1]) continue;
            if (canMove(maze, coords, newDir, path)
                    && hasPath(maze, coords, dest, newDir, path)) return true;
        }

        return false;
    }

    private boolean canMove(int[][] maze, int[] coords, int[] dir, Set<Integer> path) {
        int x = coords[0] + dir[0], y = coords[1] + dir[1];
        // boundary check
        if (x < 0 || x > maze.length - 1 || y < 0 || y > maze[0].length - 1) return false;
        int idx = to1dIndex(x, y, maze[0].length);
        // path check
        if (path.contains(idx)) return false;
        // wall check
        if (maze[x][y] == 1) return false;

        return true;
    }

    private int to1dIndex(int row, int col, int nCols) {
        return row * nCols + col;
    }
}
