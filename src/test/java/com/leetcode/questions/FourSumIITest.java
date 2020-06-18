package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FourSumIITest {
    private FourSumII fourSumII;

    @Before
    public void setUp() {
        fourSumII = new FourSumII();
    }

    @Test
    public void test_1() {
        int[] A = new int[]{1, 2};
        int[] B = new int[]{-2, -1};
        int[] C = new int[]{-1, 2};
        int[] D = new int[]{0, 2};

        int count = fourSumII.fourSumCount(A, B, C, D);

        assertThat(count).isEqualTo(2);
    }
}