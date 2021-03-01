package com.leetcode.questions.array;

public class TicTacToe {
    int[][] board;
    int n;

    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {
        board = new int[n][n];
        this.n = n;
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        board[row][col] = player;

        // horizontal
        int cnt = 0;
        for (int j = 0; j < n; j++) {
            cnt += board[row][j] == player ? 1 : 0;
        }

        if (cnt == n) return player;

        // vertical
        cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += board[i][col] == player ? 1 : 0;
        }

        if (cnt == n) return player;

        // left-diag
        cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) continue;
                cnt += board[i][j] == player ? 1 : 0;
            }
        }

        if (cnt == n) return player;

        // right-diag
        cnt = 0;
        int i = 0, j = n - 1;

        while (i < n && j > 0) {
            cnt += board[i][j] == player ? 1 : 0;

            i++;
            j--;
        }

        if (cnt == n) return player;

        return 0;
    }
}
