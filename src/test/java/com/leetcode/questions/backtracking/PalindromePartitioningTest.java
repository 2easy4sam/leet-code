package com.leetcode.questions.backtracking;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PalindromePartitioningTest {
    private PalindromePartitioning palindromePartitioning;

    @Before
    public void setUp() {
        palindromePartitioning = new PalindromePartitioning();
    }

    @Test
    public void test_1() {
        String s = "aab";

        assertThat(palindromePartitioning.partition(s)).contains(
                Arrays.asList("a", "a", "b"),
                Arrays.asList("aa", "b")
        );
    }
}