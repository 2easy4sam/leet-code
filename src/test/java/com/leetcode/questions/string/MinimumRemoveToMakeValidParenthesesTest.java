package com.leetcode.questions.string;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinimumRemoveToMakeValidParenthesesTest {
    private MinimumRemoveToMakeValidParentheses minRemoveToMakeValidParentheses;

    @Before
    public void setUp() {
        minRemoveToMakeValidParentheses = new MinimumRemoveToMakeValidParentheses();
    }

    @Test
    public void test_1() {
        String s = "lee(t(c)o)de)";

        assertThat(minRemoveToMakeValidParentheses.minRemoveToMakeValid(s)).isEqualTo("lee(t(c)o)de");
    }
}