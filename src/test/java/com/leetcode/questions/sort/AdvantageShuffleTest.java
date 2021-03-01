package com.leetcode.questions.sort;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AdvantageShuffleTest {
    private AdvantageShuffle underTest;

    @Before
    public void setUp() {
        underTest = new AdvantageShuffle();
    }

    @Test
    public void test_1() {
        int[] A = new int[]{15448, 14234, 13574, 19893, 6475};
        int[] B = new int[]{14234, 6475, 19893, 15448, 13574};

        assertThat(underTest.advantageCount(A, B));
    }
}