package com.leetcode.questions.graph;

import org.junit.Before;
import org.junit.Test;

public class AllPathsFromSourceToTargetTest {
    private AllPathsFromSourceToTarget allPathsFromSourceToTarget;

    @Before
    public void setUp() {
        allPathsFromSourceToTarget = new AllPathsFromSourceToTarget();
    }

    @Test
    public void test_1() {
        int[][] graph = {
                {1, 2},
                {3},
                {3},
                {}
        };

        allPathsFromSourceToTarget.allPathsSourceTarget(graph);
    }
}