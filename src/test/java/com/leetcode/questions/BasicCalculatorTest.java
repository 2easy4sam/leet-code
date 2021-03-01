package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicCalculatorTest {
    private BasicCalculator basicCalculator;

    @Before
    public void setUp() {
        basicCalculator = new BasicCalculator();
    }

    @Test
    public void test_1() {
        String s = "(1+(4+5+2)-3)+(6+8)";

        assertThat(basicCalculator.calculate(s)).isEqualTo(23);
    }
}