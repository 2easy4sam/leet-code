package com.leetcode.questions.backtracking;

import java.util.Arrays;

public class NQueensII {
    private int cnt = 0;

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] r : board) Arrays.fill(r, '.');

        dfs(board, new boolean[n], 0, n);

        return cnt;
    }

    private void dfs(char[][] board, boolean[] usedCols, int r, int n) {
        if (r == n) {
            cnt++;
            return;
        }

        for (int c = 0; c < n; c++) {
            if (usedCols[c]) continue;
            if (!isValid(board, r, c, n)) continue;
            usedCols[c] = true;
            board[r][c] = 'Q';

            dfs(board, usedCols, r + 1, n);

            usedCols[c] = false;
            board[r][c] = '.';
        }
    }

    private boolean isValid(char[][] board, int r, int c, int n) {
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = r, j = c; i < n && j < n; i++, j++) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = r, j = c; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = r, j = c; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }
}
