package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FormArrByConcatenatingSubArrsOrAnotherArrTest {
    private FormArrByConcatenatingSubArrsOrAnotherArr underTest;

    @Before
    public void setUp() {
        underTest = new FormArrByConcatenatingSubArrsOrAnotherArr();
    }

    @Test
    public void test_1() {
        int[][] groups = new int[][]{
                {1, -1, -1},
                {3, -2, 0}
        };

        int[] nums = new int[]{1, -1, 0, 1, -1, -1, 3, -2, 0};

        assertThat(underTest.canChoose(groups, nums)).isTrue();
    }

    @Test
    public void test_2() {
        int[][] groups = new int[][]{
                {6551094, 9427527, 2052462, 3481286, -7620442},
                {8495362, -1820796},
                {-1005271, -6911519},
                {-9667242, 9997184, -9316362},
                {-9278108, -7479063, -7573091, -1775876, -2612810, -241649}
        };

        int[] nums = {6551094, 6551094, 9427527, 2052462, 3481286, -7620442, -7620442, 8495362,
                -1820796, -1005271, -6911519, -9667242, 9997184, -9316362, 9997184, -9278108,
                -7479063, -7573091, -1775876, -2612810, -241649};

        assertThat(underTest.canChoose(groups, nums)).isTrue();
    }
}