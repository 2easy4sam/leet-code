package com.leetcode.questions.string;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestDiverseStringTest {
    private LongestDiverseString longestDiverseString;

    @Before
    public void setUp() {
        longestDiverseString = new LongestDiverseString();
    }

    @Test
    public void test_1() {
        int a = 1, b = 1, c = 7;

        assertThat(longestDiverseString.longestDiverseString(a, b, c)).isEqualTo("ccaccbcc");
    }
}