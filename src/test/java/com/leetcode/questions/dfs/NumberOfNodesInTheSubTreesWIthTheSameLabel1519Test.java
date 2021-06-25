package com.leetcode.questions.dfs;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberOfNodesInTheSubTreesWIthTheSameLabel1519Test {
    private NumberOfNodesInTheSubTreesWIthTheSameLabel1519 underTest;

    @Before
    public void setup() {
        underTest = new NumberOfNodesInTheSubTreesWIthTheSameLabel1519();
    }

    @Test
    public void test_1() {
        int n = 7;
        int[][] edges = new int[][]{
                {0, 1},
                {0, 2},
                {1, 4},
                {1, 5},
                {2, 3},
                {2, 6}
        };
        String labels = "abaedcd";

        assertThat(underTest.countSubTrees(n, edges, labels)).containsExactly(2, 1, 1, 1, 1, 1, 1);
    }
}