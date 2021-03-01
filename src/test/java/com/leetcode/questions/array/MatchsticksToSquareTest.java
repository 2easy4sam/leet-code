package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchsticksToSquareTest {
    private MatchsticksToSquare matchsticksToSquare;

    @Before
    public void setUp() {
        matchsticksToSquare = new MatchsticksToSquare();
    }

    @Test
    public void test_1() {
        int[] nums = new int[]{1, 1, 2, 2, 2};

        assertThat(matchsticksToSquare.makesquare(nums)).isTrue();
    }

    @Test
    public void test_2() {
        int[] nums = new int[]{1, 1, 1, 1};

        assertThat(matchsticksToSquare.makesquare(nums)).isTrue();
    }

    @Test
    public void test_3() {
        int[] nums = new int[]{3, 1, 3, 3, 10, 7, 10, 3, 6, 9, 10, 3, 7, 6, 7};

        boolean actual = matchsticksToSquare.makesquare(nums);
        assertThat(actual).isTrue();
    }
}