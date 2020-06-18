package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LastStoneWeightTest {
    private LastStoneWeight lastStoneWeight;

    @Before
    public void setUp() {
        lastStoneWeight = new LastStoneWeight();
    }

    @Test
    public void test_1() {
        int[] stones = new int[]{2, 7, 4, 1, 8, 1};

        assertThat(lastStoneWeight.lastStoneWeight3(stones)).isEqualTo(1);
    }

    @Test
    public void test_2() {
        int[] stones = new int[]{1, 8};

        assertThat(lastStoneWeight.lastStoneWeight3(stones)).isEqualTo(7);
    }

    @Test
    public void test_3() {
        int[] stones = new int[]{6, 6};

        assertThat(lastStoneWeight.lastStoneWeight3(stones)).isEqualTo(0);
    }

    @Test
    public void test_4() {
        int[] stones = new int[]{7, 6, 7, 6, 9};

        assertThat(lastStoneWeight.lastStoneWeight3(stones)).isEqualTo(3);
    }
}