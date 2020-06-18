package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SortArrayByParityIITest {
    private SortArrayByParityII sortArrayByParityII;

    @Before
    public void setUp() {
        sortArrayByParityII = new SortArrayByParityII();
    }

    @Test
    public void test_1() {
        int[] A = new int[]{4, 2, 5, 7};

        A = sortArrayByParityII.sortArrayByParityII(A);

        assertThat(A).containsSequence(4, 5, 2, 7);
    }
}