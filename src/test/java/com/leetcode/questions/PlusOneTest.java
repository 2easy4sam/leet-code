package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlusOneTest {
    private PlusOne plusOne;

    @Before
    public void setUp() {
        plusOne = new PlusOne();
    }

    @Test
    public void test_1() {
        int[] digits = new int[]{1, 2, 3};

        int[] sum = plusOne.plusOne2(digits);

        assertThat(sum).containsExactly(1, 2, 4);
    }

    @Test
    public void test_2() {
        int[] digits = new int[]{9, 9, 9};

        int[] sum = plusOne.plusOne2(digits);

        assertThat(sum).containsExactly(1, 0, 0, 0);
    }

    @Test
    public void test_3() {
        int[] digits = new int[]{7, 8, 9};

        int[] sum = plusOne.plusOne2(digits);

        assertThat(sum).containsExactly(7, 9, 0);
    }
}