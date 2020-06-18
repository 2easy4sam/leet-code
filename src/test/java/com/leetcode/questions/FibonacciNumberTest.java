package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FibonacciNumberTest {
    private FibonacciNumber fibonacciNumber;

    @Before
    public void setUp() {
        fibonacciNumber = new FibonacciNumber();
    }

    @Test
    public void test_1() {
        assertThat(fibonacciNumber.fib(2)).isEqualTo(1);
    }

    @Test
    public void test_2() {
        assertThat(fibonacciNumber.fib(3)).isEqualTo(2);
    }

    @Test
    public void test_3() {
        assertThat(fibonacciNumber.fib(4)).isEqualTo(3);
    }
}