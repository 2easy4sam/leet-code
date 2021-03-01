package com.leetcode.questions.bst;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckIfThereIsAValidPathInGridTest {
    private CheckIfThereIsAValidPathInGrid checkIfThereIsAValidPathInGrid;

    @Before
    public void setUp() {
        checkIfThereIsAValidPathInGrid = new CheckIfThereIsAValidPathInGrid();
    }

    @Test
    public void test_1() {
        int[][] grid = new int[][]{
                {2, 4, 3},
                {6, 5, 2}
        };

        assertThat(checkIfThereIsAValidPathInGrid.hasValidPath(grid)).isTrue();
    }

    @Test
    public void test_2() {
        int[][] grid = new int[][]{
                {2, 6, 3},
                {6, 5, 2}
        };

        assertThat(checkIfThereIsAValidPathInGrid.hasValidPath(grid)).isFalse();
    }
}