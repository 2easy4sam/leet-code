package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PalindromePermutationTest {
    private PalindromePermutation palindromePermutation;

    @Before
    public void setUp() {
        palindromePermutation = new PalindromePermutation();
    }

    @Test
    public void test_1() {
        assertThat(palindromePermutation.canPermutePalindrome("code")).isFalse();
    }

    @Test
    public void test_2() {
        assertThat(palindromePermutation.canPermutePalindrome("aab")).isTrue();
    }

    @Test
    public void test_3() {
        assertThat(palindromePermutation.canPermutePalindrome("carerac")).isTrue();
    }

    @Test
    public void test_4() {
        assertThat(palindromePermutation.canPermutePalindrome("aabb")).isTrue();
    }

    @Test
    public void test_5() {
        assertThat(palindromePermutation.canPermutePalindrome("caabb")).isTrue();
    }
}