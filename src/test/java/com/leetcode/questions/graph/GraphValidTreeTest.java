package com.leetcode.questions.graph;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GraphValidTreeTest {
    private GraphValidTree graphValidTree;

    @Before
    public void setUp() {
        graphValidTree = new GraphValidTree();
    }

    @Test
    public void test_1() {
        int n = 5;
        int[][] edges = new int[][]{
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 4}
        };

        assertThat(graphValidTree.validTree(n, edges)).isTrue();
    }
}