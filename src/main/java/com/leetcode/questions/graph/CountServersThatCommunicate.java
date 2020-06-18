package com.leetcode.questions.graph;

/**
 * You are given a map of a server center, represented as a m * n
 * integer matrix grid, where 1 means that on that cell there is a
 * server and 0 means that it is no server. Two servers are said to
 * communicate if they are on the same row or on the same column.
 * <p>
 * Return the number of servers that communicate with any other
 * server.
 */
public class CountServersThatCommunicate {
    /**
     * space: O(m + n)
     * time: O(mn)
     */
    public int countServers(int[][] grid) {
        int cnt = 0;
        int nRows = grid.length, nCols = grid[0].length;
        int rowCnt[] = new int[nRows];
        int colCnt[] = new int[nCols];

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (grid[i][j] == 1) {
                    rowCnt[i]++;
                    colCnt[j]++;
                    cnt++;
                }
            }
        }

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                // IF [i, j] has a server
                // AND is the only server in the entire row and col
                // THEN it is not communicating with any servers
                if (grid[i][j] == 1 && rowCnt[i] == 1 && colCnt[j] == 1)
                    cnt--;
            }
        }

        return cnt;
    }
}
