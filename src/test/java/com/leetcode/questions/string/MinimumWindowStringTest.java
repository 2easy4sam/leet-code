package com.leetcode.questions.string;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinimumWindowStringTest {
    private MinimumWindowString minimumWindowString;

    @Before
    public void setUp() {
        minimumWindowString = new MinimumWindowString();
    }

    @Test
    public void test_1() {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        assertThat(minimumWindowString.minWindow(s, t)).isEqualTo("BANC");
    }
}