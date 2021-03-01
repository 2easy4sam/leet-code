package com.leetcode.questions.stack;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinInsertionsToBalanceParenthesesTest {
    private MinInsertionsToBalanceParentheses underTest;

    @Before
    public void setUp() {
        underTest = new MinInsertionsToBalanceParentheses();
    }

    @Test
    public void test_1() {
        String s = "))())(";

        assertThat(underTest.minInsertions(s)).isEqualTo(3);
    }
}