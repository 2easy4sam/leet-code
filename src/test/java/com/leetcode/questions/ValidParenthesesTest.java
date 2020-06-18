package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidParenthesesTest {
    private ValidParentheses validParentheses;

    @Before
    public void setUp() {
        validParentheses = new ValidParentheses();
    }

    @Test
    public void test_1() {
        assertThat(validParentheses.isValid("()")).isTrue();
    }

    @Test
    public void test_2() {
        assertThat(validParentheses.isValid("()[]{}")).isTrue();
    }

    @Test
    public void test_3() {
        assertThat(validParentheses.isValid("(]")).isFalse();
    }

    @Test
    public void test_4() {
        assertThat(validParentheses.isValid("([)]")).isFalse();
    }

    @Test
    public void test_5() {
        assertThat(validParentheses.isValid("{[]}")).isTrue();
    }

    @Test
    public void test_6() {
        assertThat(validParentheses.isValid("){")).isFalse();
    }
}