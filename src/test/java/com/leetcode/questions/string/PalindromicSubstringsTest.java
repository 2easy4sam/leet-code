package com.leetcode.questions.string;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PalindromicSubstringsTest {
    private PalindromicSubstrings palindromicSubstrings;

    @Before
    public void setUp() {
        palindromicSubstrings = new PalindromicSubstrings();
    }

    @Test
    public void test_1() {
        String s = "aaa";

        assertThat(palindromicSubstrings.countSubstrings(s)).isEqualTo(6);
    }
}