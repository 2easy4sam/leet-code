package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicCalculatorIIITest {
    private BasicCalculatorIII basicCalculatorIII;

    @Before
    public void setUp() {
        basicCalculatorIII = new BasicCalculatorIII();
    }

    @Test
    public void test_1() {
        String expr = "2 * (2+2) / 2";

        assertThat(basicCalculatorIII.calculate(expr)).isEqualTo(4);
    }
}