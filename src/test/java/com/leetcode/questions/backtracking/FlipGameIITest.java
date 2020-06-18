package com.leetcode.questions.backtracking;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FlipGameIITest {
    private FlipGameII flipGameII;

    @Before
    public void setUp() {
        flipGameII = new FlipGameII();
    }

    @Test
    public void test_1() {
        String s = "+++++++++";
        assertThat(flipGameII.canWin(s)).isFalse();
    }
}