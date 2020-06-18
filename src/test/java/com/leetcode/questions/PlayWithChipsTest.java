package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayWithChipsTest {
    private PlayWithChips playWithChips;

    @Before
    public void setUp() {
        playWithChips = new PlayWithChips();
    }

    @Test
    public void test_1() {
        assertThat(playWithChips.minCostToMoveChips(new int[]{1, 2, 3})).isEqualTo(1);
    }

    @Test
    public void test_2() {
        assertThat(playWithChips.minCostToMoveChips(new int[]{2, 2, 2, 3, 3})).isEqualTo(2);
    }

    @Test
    public void test_3() {
        assertThat(playWithChips.minCostToMoveChips(new int[]{1, 2, 2, 2, 2})).isEqualTo(1);
    }
}