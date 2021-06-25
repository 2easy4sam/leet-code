package com.leetcode.questions.bfs;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinMovesToMoveABoxToTheirTargetLocationTest {
    private MinMovesToMoveABoxToTheirTargetLocation underTest;

    @Before
    public void setUp() {
        underTest = new MinMovesToMoveABoxToTheirTargetLocation();
    }

    @Test
    public void test_1() {
        char[][] grid = new char[][]{
                {'#', '#', '#', '#', '#', '#'},
                {'#', 'T', '#', '#', '#', '#'},
                {'#', '.', '.', 'B', '.', '#'},
                {'#', '.', '#', '#', '.', '#'},
                {'#', '.', '.', '.', 'S', '#'},
                {'#', '#', '#', '#', '#', '#'}
        };

        assertThat(underTest.minPushBox(grid)).isEqualTo(3);
    }
}