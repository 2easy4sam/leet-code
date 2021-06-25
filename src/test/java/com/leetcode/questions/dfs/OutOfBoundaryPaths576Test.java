package com.leetcode.questions.dfs;

import org.junit.Before;
import org.junit.Test;

public class OutOfBoundaryPaths576Test {
    private OutOfBoundaryPaths576 underTest;

    @Before
    public void setup() {
        underTest = new OutOfBoundaryPaths576();
    }

    @Test
    public void test_1() {
        int cnt = underTest.findPaths(8, 7, 16, 1, 5);
        System.out.println(cnt);
    }
}