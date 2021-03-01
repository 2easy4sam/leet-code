package com.leetcode.questions.dfs;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DifferentWaysToAddParenthesesTest {
    private DifferentWaysToAddParentheses differentWaysToAddParentheses;

    @Before
    public void setUp() {
        differentWaysToAddParentheses = new DifferentWaysToAddParentheses();
    }

    @Test
    public void test_1() {
        String expr = "2-1";

        assertThat(differentWaysToAddParentheses.diffWaysToCompute(expr)).containsOnly(1);
    }

    @Test
    public void test_2() {
        String expr = "2*3-4*5";

        assertThat(differentWaysToAddParentheses.diffWaysToCompute(expr)).contains(-34, -14, -10, -10, 10);
    }
}