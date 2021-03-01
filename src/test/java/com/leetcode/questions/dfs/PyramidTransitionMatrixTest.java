package com.leetcode.questions.dfs;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PyramidTransitionMatrixTest {
    private PyramidTransitionMatrix pyramidTransitionMatrix;

    @Before
    public void setUp() {
        pyramidTransitionMatrix = new PyramidTransitionMatrix();
    }

    @Test
    public void test_1() {
        String bottom = "BCD";
        List<String> allowed = Arrays.asList("BCG", "CDE", "GEA", "FFF");

        assertThat(pyramidTransitionMatrix.pyramidTransition(bottom, allowed)).isTrue();
    }
}