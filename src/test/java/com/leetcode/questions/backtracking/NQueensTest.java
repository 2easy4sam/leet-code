package com.leetcode.questions.backtracking;

import org.junit.Before;
import org.junit.Test;

public class NQueensTest {
    private NQueens underTest;

    @Before
    public void setUp() {
        underTest = new NQueens();
    }

    @Test
    public void test_1() {
        underTest.solveNQueens(4);
    }
}