package com.leetcode.questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> rowMap = new HashMap<>();
        Map<Integer, Set<Integer>> colMap = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            rowMap.put(i, new HashSet<>());

            for (int j = 0; j < 9; j++) {
                // check 3x3 sub-box
                if ((i == 1 || i == 4 || i == 7) && (j == 1 || j == 4 || j == 7)) {
                    Set<Integer> subBoxSet = new HashSet<>();

                    for (int row = i - 1; row <= i + 1; row++) {
                        for (int col = j - 1; col <= j + 1; col++) {
                            if (board[row][col] != '.') {
                                if (!subBoxSet.add(board[row][col] - '0')) {
                                    return false;
                                }
                            }
                        }
                    }
                }

                if (board[i][j] != '.') {
                    int val = board[i][j] - '0';

                    if (!rowMap.get(i).add(val)) {
                        return false;
                    }

                    if (!colMap.containsKey(j)) {
                        Set<Integer> colSet = new HashSet<>();
                        colSet.add(val);
                        colMap.put(j, colSet);
                    } else if (!colMap.get(j).add(val)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
