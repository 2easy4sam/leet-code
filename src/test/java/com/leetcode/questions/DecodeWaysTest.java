package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DecodeWaysTest {
    private DecodeWays decodeWays;

    @Before
    public void setUp() {
        decodeWays = new DecodeWays();
    }

    @Test
    public void test_1() {
        String s = "226";

        assertThat(decodeWays.numDecodings(s)).isEqualTo(3);
    }

    @Test
    public void test_2() {
        String s = "227";

        assertThat(decodeWays.numDecodings(s)).isEqualTo(2);
    }
}