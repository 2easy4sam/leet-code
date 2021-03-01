package com.leetcode.questions.string;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReverseSubstrBetweenEachPairOfParenthesesTest {
    private ReverseSubstrBetweenEachPairOfParentheses reverseSubstrBetweenEachPairOfParentheses;

    @Before
    public void setUp() {
        reverseSubstrBetweenEachPairOfParentheses = new ReverseSubstrBetweenEachPairOfParentheses();
    }

    @Test
    public void test_1() {
        String s = "f(ul)ao(t(y)qbn)()sj";

        assertThat(reverseSubstrBetweenEachPairOfParentheses.reverseParentheses(s)).isEqualTo("iloveu");
    }
}