package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidPalindromeIITest {
    private ValidPalindromeII validPalindromeII;

    @Before
    public void setUp() {
        validPalindromeII = new ValidPalindromeII();
    }

    @Test
    public void test_1() {
        String s = "aba";

        assertThat(validPalindromeII.validPalindrome(s)).isTrue();
    }

    @Test
    public void test_2() {
        String s = "abca";

        assertThat(validPalindromeII.validPalindrome(s)).isTrue();
    }

    @Test
    public void test_3() {
        String s = "a";

        assertThat(validPalindromeII.validPalindrome(s)).isTrue();
    }

    @Test
    public void test_4() {
        String s = "abcda";

        assertThat(validPalindromeII.validPalindrome(s)).isFalse();
    }

    @Test
    public void test_5() {
        String s = "deeee";

        assertThat(validPalindromeII.validPalindrome(s)).isTrue();
    }

    @Test
    public void test_6() {
        String s = "aabdeenddbaagbddeedbaa";

        assertThat(validPalindromeII.validPalindrome(s)).isFalse();
    }

    @Test
    public void test_7() {
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";

        assertThat(validPalindromeII.validPalindrome(s)).isTrue();
    }
}