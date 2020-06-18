package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReduceArraySizeToTheHalfTest {
    private ReduceArraySizeToTheHalf reduceArraySizeToTheHalf;

    @Before
    public void setUp() {
        reduceArraySizeToTheHalf = new ReduceArraySizeToTheHalf();
    }

    @Test
    public void test_1() {
        int[] arr = new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7};

        assertThat(reduceArraySizeToTheHalf.minSetSize(arr)).isEqualTo(2);
    }
}