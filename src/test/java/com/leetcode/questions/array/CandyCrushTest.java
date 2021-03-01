package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

public class CandyCrushTest {
    private CandyCrush candyCrush;

    @Before
    public void setup() {
        candyCrush = new CandyCrush();
    }

    @Test
    public void test_1() {
        int[][] board = new int[][]{
                {110, 5, 112, 113, 114},
                {210, 211, 5, 213, 214},
                {310, 311, 3, 313, 314},
                {410, 411, 412, 5, 414},
                {5, 1, 512, 3, 3},
                {610, 4, 1, 613, 614},
                {710, 1, 2, 713, 714},
                {810, 1, 2, 1, 1},
                {1, 1, 2, 2, 2},
                {4, 1, 4, 4, 1014}
        };

        candyCrush.candyCrush(board);
    }
}