package com.leetcode.questions.dfs;

import java.util.Arrays;

public class TheMaze {
    /*
    - a cell is either visited (from a certain direction) or not visited
        - use a 2d int array to keep track of the status of each cell
        8   4   2   1
                    0   unvisited
                    1   visited (north)
                1   0   vistied (east)
                1   1   vistied (north + east)
    - when stopped
        - check if the current cell == destination
            - IF yes, THEN return true
            - ELSE choose a different direction
    - only come to a stop when
        - there's a wall
        - reached the border

    */

    private static int[][] DIRS = new int[][]{
            {-1, 0},     // NORTH
            {0, 1},      // EAST
            {1, 0},      // SOUTH
            {0, -1}      // WEST
    };

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] startedHere = new boolean[maze.length][maze[0].length];

        return dfs(maze, startedHere, start, destination);
    }

    private boolean dfs(int[][] maze, boolean[][] startedHere, int[] curr, int[] dest) {
        if (startedHere[curr[0]][curr[1]]) return false;
        if (Arrays.equals(curr, dest)) return true;

        startedHere[curr[0]][curr[1]] = true;

        for (int[] dir : DIRS) {
            int[] next = roll(maze, curr[0], curr[1], dir[0], dir[1]);
            if (dfs(maze, startedHere, next, dest)) return true;
        }

        return false;
    }

    private int[] roll(int[][] maze, int x, int y, int xInc, int yInc) {
        while (canRoll(maze, x + xInc, y + yInc)) {
            x += xInc;
            y += yInc;
        }

        return new int[]{x, y};
    }

    private boolean canRoll(int[][] maze, int x, int y) {
        if (x < 0 || x == maze.length || y < 0 || y == maze[0].length) return false;
        return maze[x][y] != 1;
    }
}
