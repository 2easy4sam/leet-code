package com.leetcode.learn.queue;

import java.util.*;

public class WallsAndGates {
    private static final int EMPTY_ROOM = Integer.MAX_VALUE;
    private static final int WALL = -1;
    private static final int GATE = 0;
    private static final int[][] NEIGHBOUR_COORDS = new int[][]{
            {-1, 0},    // N
            {0, 1},     // E
            {1, 0},     // S
            {0, -1}     // W
    };

    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) return;

        final int nRows = rooms.length;
        final int nCols = rooms[0].length;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (rooms[i][j] == GATE) q.add(new int[]{i, j});
            }
        }

        while (!q.isEmpty()) {
            int[] currentCoords = q.poll();

            if (currentCoords != null) {

                int currentRoom = rooms[currentCoords[0]][currentCoords[1]];

                for (int[] coords : NEIGHBOUR_COORDS) {
                    int row = currentCoords[0] + coords[0];
                    int col = currentCoords[1] + coords[1];

                    // make sure it's not outside the boundaries
                    if (row > -1 && row < nRows && col > -1 && col < nCols && rooms[row][col] == EMPTY_ROOM) {
                        rooms[row][col] = currentRoom + 1;
                        q.add(new int[]{row, col});
                    }
                }
            }
        }
    }
}
