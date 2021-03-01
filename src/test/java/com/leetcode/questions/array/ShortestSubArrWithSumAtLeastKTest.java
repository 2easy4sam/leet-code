package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShortestSubArrWithSumAtLeastKTest {
    private ShortestSubArrWithSumAtLeastK shortestSubArrWithSumAtLeastK;

    @Before
    public void setUp() {
        shortestSubArrWithSumAtLeastK = new ShortestSubArrWithSumAtLeastK();
    }

    @Test
    public void test_1() {
        int[] arr = {1, 2};
        int K = 3;

        assertThat(shortestSubArrWithSumAtLeastK.shortestSubarray(arr, K)).isEqualTo(2);
    }

    @Test
    public void test_2() {
        int[] arr = {84, -37, 32, 40, 95};
        int K = 167;

        assertThat(shortestSubArrWithSumAtLeastK.shortestSubarray(arr, K)).isEqualTo(3);
    }

    @Test
    public void test_3() {
        int[] arr = {-28, 81, -20, 28, -29};
        int K = 89;

        assertThat(shortestSubArrWithSumAtLeastK.shortestSubarray(arr, K)).isEqualTo(3);
    }
}