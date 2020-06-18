package com.leetcode.questions.graph;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RedundantConnectionTest {
    private RedundantConnection redundantConnection;

    @Before
    public void setup() {
        redundantConnection = new RedundantConnection();
    }

    @Test
    public void test_1() {
        int[][] edges = new int[][]{
                {1, 2},
                {1, 3},
                {2, 3}
        };

        int[] edge = redundantConnection.findRedundantConnection(edges);

        assertThat(edge).containsExactly(2, 3);
    }
}