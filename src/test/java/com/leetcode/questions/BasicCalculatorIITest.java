package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicCalculatorIITest {
    private BasicCalculatorII basicCalculatorII;

    @Before
    public void setUp() {
        basicCalculatorII = new BasicCalculatorII();
    }

    @Test
    public void test_1() {
        String exp = "3+2*2";

        assertThat(basicCalculatorII.calculate(exp)).isEqualTo(7);
    }
}