package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TotalHammingDistanceTest {
    private TotalHammingDistance totalHammingDistance;

    @Before
    public void setUp() {
        totalHammingDistance = new TotalHammingDistance();
    }

    @Test
    public void test_1() {
        int[] nums = new int[]{4, 14, 2};

        assertThat(totalHammingDistance.totalHammingDistance(nums)).isEqualTo(6);
    }
}