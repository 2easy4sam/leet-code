package com.leetcode.questions.dfs;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TheMazeIIITest {
    private TheMazeIII underTest;

    @Before
    public void setUp() {
        underTest = new TheMazeIII();
    }

    @Test
    public void test_1() {
        int[][] maze = new int[][]{
                {0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 1, 0, 0, 0}
        };

        int[] start = new int[]{4, 3};
        int[] dest = new int[]{0, 1};

        assertThat(underTest.findShortestWay(maze, start, dest)).isEqualTo("lul");
    }
}