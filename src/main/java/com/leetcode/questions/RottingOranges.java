package com.leetcode.questions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * In a given grid, each cell can have one of three values:
 *
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent
 * (4-directionally) to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse
 * until no cell has a fresh orange.
 * If this is impossible, return -1 instead.
 */
public class RottingOranges {
    private static final int FRESH = 1;
    private static final int ROTTEN = 2;
    private static final int[] LEFT_COORDS = new int[]{0, -1};
    private static final int[] TOP_COORDS = new int[]{-1, 0};
    private static final int[] RIGHT_COORDS = new int[]{0, 1};
    private static final int[] BOTTOM_COORDS = new int[]{1, 0};

    private static final int[][] NEIGHBOUR_COORDS = new int[][]{
            LEFT_COORDS,
            TOP_COORDS,
            RIGHT_COORDS,
            BOTTOM_COORDS
    };

    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        boolean turned;
        Set<Integer> visitedRotten = new HashSet<>();
        Set<Integer> visitedFresh = new HashSet<>();
        Set<Integer> rottingFresh = new HashSet<>();
        final int nRows = grid.length;
        final int nCols = grid[0].length;
        Queue<int[]> freshQ = new LinkedList<>();
        Queue<int[]> rottingQ = new LinkedList<>();

        // we use BFS to
        // 1. check if there are unreachable/isolated FRESH oranges
        // 2. find adjacent FRESH ones around ROTTEN ones
        do {
            turned = false;

            for (int i = 0; i < nRows; i++) {
                for (int j = 0; j < nCols; j++) {

                    int idx = get1DIndex(i, j, nCols);

                    if (grid[i][j] == FRESH && !visitedFresh.contains(idx)) {
                        // keep track of reachable rotten oranges around it
                        int rottenCount = 0;
                        freshQ.add(new int[]{i, j});

                        while (!freshQ.isEmpty()) {
                            int[] top = freshQ.poll();
                            visitedFresh.add(get1DIndex(top[0], top[1], nCols));

                            // check if it's an unreachable loner
                            for (int[] coords : NEIGHBOUR_COORDS) {
                                int row = top[0] + coords[0];
                                int col = top[1] + coords[1];

                                if (row >= 0 && row < nRows && col >= 0 && col < nCols) {
                                    if (grid[row][col] == ROTTEN) rottenCount++;
                                    else if (grid[row][col] == FRESH
                                            && !visitedFresh.contains(get1DIndex(row, col, nCols)))
                                    {
                                        visitedFresh.add(get1DIndex(row, col, nCols));
                                        freshQ.add(new int[]{row, col});
                                    }
                                }
                            }
                        }

                        if (rottenCount == 0) return -1;
                    } else if (grid[i][j] == ROTTEN && !visitedRotten.contains(idx)) {
                        visitedRotten.add(idx);

                        // rot adjacent FRESH oranges
                        for (int[] coords : NEIGHBOUR_COORDS) {
                            int row = i + coords[0];
                            int col = j + coords[1];

                            if (row >= 0 && row < nRows &&
                                    col >= 0 && col < nCols &&
                                    grid[row][col] == FRESH &&
                                    !rottingFresh.contains(get1DIndex(row, col, nCols))) {
                                rottingFresh.add(get1DIndex(row, col, nCols));
                                rottingQ.add(new int[]{row, col});
                            }
                        }
                    }
                }
            }

            // no rotten and no fresh ones
            if (visitedFresh.isEmpty()) return 0;

            // start rotting the fresh ones
            while (!rottingQ.isEmpty()) {
                int[] top = rottingQ.poll();
                grid[top[0]][top[1]] = ROTTEN;
                turned = true;
            }

            if (turned) minutes++;

        } while (turned);

        return minutes;
    }

    private int get1DIndex(int row, int col, int nCols) {
        return row * nCols + col;
    }
}
