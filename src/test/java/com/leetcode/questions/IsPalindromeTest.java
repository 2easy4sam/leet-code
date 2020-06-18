package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IsPalindromeTest {
    private IsPalindrome isPalindrome;

    @Before
    public void setUp() {
        isPalindrome = new IsPalindrome();
    }

    @Test
    public void test_1() {
        String s = "A man, a plan, a canal: Panama";

        assertThat(isPalindrome.isPalindrome(s)).isTrue();
    }

    @Test
    public void test_2() {
        String s = "race a car";

        assertThat(isPalindrome.isPalindrome(s)).isFalse();
    }

    @Test
    public void test_3() {
        String s = "";

        assertThat(isPalindrome.isPalindrome(s)).isTrue();
    }
}