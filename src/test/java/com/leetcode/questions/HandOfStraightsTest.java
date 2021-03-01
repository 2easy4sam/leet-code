package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HandOfStraightsTest {
    private HandOfStraights handOfStraights;

    @Before
    public void setUp() {
        handOfStraights = new HandOfStraights();
    }

    @Test
    public void test_1() {
        int[] hand = new int[]{1,1,2,2,3,3};
        int W = 2;

        assertThat(handOfStraights.isNStraightHand(hand, W)).isFalse();
    }
}