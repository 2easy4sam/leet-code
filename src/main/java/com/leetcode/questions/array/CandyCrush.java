package com.leetcode.questions.array;

public class CandyCrush {
    public int[][] candyCrush(int[][] board) {

        int nRows = board.length, nCols = board[0].length;
        boolean deleted = true;

        while (deleted) {
            deleted = false;
            boolean[][] state = new boolean[nRows][nCols];

            for (int row = 0; row < nRows; row++) {
                for (int col = 0; col < nCols; col++) {
                    if (board[row][col] == 0) continue;
                    // traverse down
                    int x = row;
                    int cnt = 1;
                    while (x < nRows - 1 && board[x][col] == board[x + 1][col]) {
                        x++;
                        cnt++;
                    }

                    if (cnt >= 3) {
                        while (x >= row) {
                            state[x--][col] = true;
                        }
                        deleted = true;
                    }

                    // traverse right
                    int y = col;
                    cnt = 1;
                    while (y < nCols - 1 && board[row][y] == board[row][y + 1]) {
                        y++;
                        cnt++;
                    }

                    if (cnt >= 3) {
                        while (y >= col) {
                            state[row][y--] = true;
                        }
                        deleted = true;
                    }
                }
            }

            for (int col = 0; col < nCols; col++) {
                int row = nRows - 1;
                int totalDelCnt = 0;

                while (row >= 0) {
                    int delCnt = 0;

                    while (row >= 0 && !state[row][col]) {
                        row--;
                    }

                    while (row >= 0 && state[row][col]) {
                        row--;
                        delCnt++;
                    }

                    int tmp = Math.max(0, row);
                    totalDelCnt += delCnt;

                    if (totalDelCnt > 0) {
                        while (tmp >= 0 && !state[tmp][col]) {
                            board[tmp + totalDelCnt][col] = board[tmp][col];
                            tmp--;
                        }
                    }

                    row--;
                }

                int tmp = 0;

                while (totalDelCnt > 0) {
                    board[tmp][col] = 0;
                    tmp++;
                    totalDelCnt--;
                }
            }
        }

        return board;
    }
}
