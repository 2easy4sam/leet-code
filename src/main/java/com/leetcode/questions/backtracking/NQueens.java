package com.leetcode.questions.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (char[] r : board) Arrays.fill(r, '.');

        List<List<String>> ans = new ArrayList<>();

        dfs(board, new boolean[n], ans, 0, n);

        return ans;
    }

    private void dfs(char[][] board, boolean[] usedCols, List<List<String>> ans, int r, int n) {
        if (r == n) return;

        for (int c = 0; c < n; c++) {
            if (usedCols[c]) continue;

            if (isValid(board, r, c, n)) {
                usedCols[c] = true;
                board[r][c] = 'Q';

                if (r == n - 1) {
                    ans.add(toList(board));
                } else {
                    dfs(board, usedCols, ans, r + 1, n);
                }

                usedCols[c] = false;
                board[r][c] = '.';
            }
        }
    }

    private List<String> toList(char[][] board) {
        List<String> list = new ArrayList<>();

        for (char[] r : board) {
            list.add(new String(r));
        }

        return list;
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
