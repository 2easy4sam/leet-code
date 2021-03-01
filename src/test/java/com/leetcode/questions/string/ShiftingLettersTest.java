package com.leetcode.questions.string;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShiftingLettersTest {
    private ShiftingLetters shiftingLetters;

    @Before
    public void setUp() {
        shiftingLetters = new ShiftingLetters();
    }

    @Test
    public void test_1() {
        String S = "abcdef";
        int[] shifts = {3, 5, 9, 10, 2, 20};

        assertThat(shiftingLetters.shiftingLetters(S, shifts)).isEqualTo("xvrjaz");
    }
}