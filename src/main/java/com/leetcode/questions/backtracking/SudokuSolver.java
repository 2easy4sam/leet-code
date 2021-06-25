package com.leetcode.questions.backtracking;

import java.util.HashMap;
import java.util.Map;

public class SudokuSolver {
    /*
    - rules:
        1. [1..9] must occur once each row
        2. [1..9] must occur once each col
        3. [1..9] must occur once each 3x3 box
    - to address rule 1, use a boolean[10] to keep track of the status of each digit in each row
    - to address rule 2, use the same method as above
    - to address rule 3, we can:
        - use a hashmap m1 to store coords<->boxNo relationship, use another hashmap m2 to track the status of each digit in that particular box
    - 9 * 9 = 81 cells
        - stop condition: when all 81 cells are filled
    */
    public void solveSudoku(char[][] board) {
        boolean[][] used_row = new boolean[9][10], used_col = new boolean[9][10], used_box = new boolean[9][10];
        Map<Integer, Integer> map = new HashMap<>();

        int n = 81;

        for (int i = 0, boxId = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3, boxId++) {
                assignBoxId(map, i, j, boxId);
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    n--;
                    int num = board[i][j] - '0';
                    used_row[i][num] = true;
                    used_col[j][num] = true;
                    used_box[map.get(get1dIdx(i, j))][num] = true;
                }
            }
        }

        dfs(board, used_row, used_col, used_box, map, n);
    }

    private boolean dfs(char[][] board, boolean[][] used_row, boolean[][] used_col, boolean[][] used_box, Map<Integer, Integer> map, int n) {
        if (n == 0) return true;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue;

                for (int num = 1; num <= 9; num++) {
                    int boxId = map.get(get1dIdx(i, j));

                    if (used_row[i][num] || used_col[j][num] || used_box[boxId][num]) continue;
                    used_row[i][num] = true;
                    used_col[j][num] = true;
                    used_box[boxId][num] = true;
                    board[i][j] = (char) (num + '0');

                    if (dfs(board, used_row, used_col, used_box, map, n - 1)) return true;

                    used_row[i][num] = false;
                    used_col[j][num] = false;
                    used_box[boxId][num] = false;
                    board[i][j] = '.';
                }

                return false;
            }
        }

        return false;
    }

    private void assignBoxId(Map<Integer, Integer> map, int r, int c, int boxId) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map.put(get1dIdx(r + i, c + j), boxId);
            }
        }
    }

    private int get1dIdx(int r, int c) {
        return r * 9 + c;
    }
}
