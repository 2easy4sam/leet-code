package com.leetcode.questions.backtracking;

import org.junit.Before;
import org.junit.Test;

public class SudokuSolverTest {
    private SudokuSolver underTest;

    @Before
    public void setUp() {
        underTest = new SudokuSolver();
    }

    @Test
    public void test_1() {
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        underTest.solveSudoku(board);
    }
}