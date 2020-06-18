package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxSumOfTwoNonOverlappingSubArrsTest {
    private MaxSumOfTwoNonOverlappingSubArrs maxSumOfTwoNonOverlappingSubArrs;

    @Before
    public void setUp() {
        maxSumOfTwoNonOverlappingSubArrs = new MaxSumOfTwoNonOverlappingSubArrs();
    }

    @Test
    public void test_withArraySortedInAscendingOrder() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int L = 1, M = 2;

        assertThat(maxSumOfTwoNonOverlappingSubArrs.maxSumTwoNoOverlap(arr, L, M)).isEqualTo(12);
    }

    @Test
    public void test_withArraySortedInDescendingOrder() {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        int L = 1, M = 2;

        assertThat(maxSumOfTwoNonOverlappingSubArrs.maxSumTwoNoOverlap(arr, L, M)).isEqualTo(12);
    }
}