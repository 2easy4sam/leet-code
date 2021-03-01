package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxLenOfRepeatedSubarrTest {
    private MaxLenOfRepeatedSubarr maxLenOfRepeatedSubarr;

    @Before
    public void setUp() {
        maxLenOfRepeatedSubarr = new MaxLenOfRepeatedSubarr();
    }

    @Test
    public void test_1() {
        int[] A = {1, 0, 0, 0, 1};
        int[] B = {1, 0, 0, 1, 1};

        assertThat(maxLenOfRepeatedSubarr.findLength(A, B)).isEqualTo(3);
    }
}