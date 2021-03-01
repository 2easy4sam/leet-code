package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RotatedDigitsTest {
    private RotatedDigits rotatedDigits;

    @Before
    public void setup() {
        rotatedDigits = new RotatedDigits();
    }

    @Test
    public void test_1() {
        assertThat(rotatedDigits.rotatedDigits(10)).isEqualTo(4);
    }
}