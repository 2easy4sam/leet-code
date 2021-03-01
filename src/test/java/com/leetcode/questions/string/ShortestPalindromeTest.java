package com.leetcode.questions.string;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShortestPalindromeTest {
    private ShortestPalindrome underTest;

    @Before
    public void setUp() {
        underTest = new ShortestPalindrome();
    }

    @Test
    public void test_1() {
        String s = "aabba";

        assertThat(underTest.shortestPalindrome(s)).isEqualTo("abbaabba");
    }

    @Test
    public void test_2() {
        String s = "aaaabba";

        assertThat(underTest.shortestPalindrome(s)).isEqualTo("abbaabba");
    }
}