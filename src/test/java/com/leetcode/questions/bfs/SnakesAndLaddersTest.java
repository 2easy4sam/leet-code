package com.leetcode.questions.bfs;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SnakesAndLaddersTest {
    private SnakesAndLadders underTest;

    @Before
    public void setUp() {
        underTest = new SnakesAndLadders();
    }

    @Test
    public void test_1() {
        int[][] board = new int[][]{
                {-1, 7, -1},
                {-1, 6, 9},
                {-1, -1, 2}
        };

        assertThat(underTest.snakesAndLadders(board)).isEqualTo(1);
    }

    @Test
    public void test_2() {
        int[][] board = new int[][]{
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };

        assertThat(underTest.snakesAndLadders(board)).isEqualTo(4);
    }

    @Test
    public void test_3() {
        int[][] board = new int[][]{
                {-1, 4, -1},
                {6, 2, 6},
                {-1, 3, -1}
        };

        assertThat(underTest.snakesAndLadders(board)).isEqualTo(2);
    }

    @Test
    public void test_4() {
        int[][] board = new int[][]{
                {-1, -1, 30, 14, 15, -1},
                {23, 9, -1, -1, -1, 9},
                {12, 5, 7, 24, -1, 30},
                {10, -1, -1, -1, 25, 17},
                {32, -1, 28, -1, -1, 32},
                {-1, -1, 23, -1, 13, 19}
        };

        assertThat(underTest.snakesAndLadders(board)).isEqualTo(2);
    }
}