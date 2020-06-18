package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PerfectNumberTest {
    private PerfectNumber perfectNumber;

    @Before
    public void setUp() {
        perfectNumber = new PerfectNumber();
    }

    @Test
    public void test_1() {
        assertThat(perfectNumber.checkPerfectNumber(28)).isTrue();
    }

    @Test
    public void test_2() {
        assertThat(perfectNumber.checkPerfectNumber(16)).isFalse();
    }
}