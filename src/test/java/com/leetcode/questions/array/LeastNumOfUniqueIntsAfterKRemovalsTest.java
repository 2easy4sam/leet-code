package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LeastNumOfUniqueIntsAfterKRemovalsTest {
    private LeastNumOfUniqueIntsAfterKRemovals leastNumOfUniqueIntsAfterKRemovals;

    @Before
    public void setUp() {
        leastNumOfUniqueIntsAfterKRemovals = new LeastNumOfUniqueIntsAfterKRemovals();
    }

    @Test
    public void test_1() {
        int[] arr = {5, 5, 4};

        assertThat(leastNumOfUniqueIntsAfterKRemovals.findLeastNumOfUniqueInts(arr, 1)).isEqualTo(1);
    }
}