package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberComplementTest {
    private NumberComplement numberComplement;

    @Before
    public void setUp() {
        numberComplement = new NumberComplement();
    }

    @Test
    public void test_1() {
        assertThat(numberComplement.findComplement(5)).isEqualTo(2);
    }

    @Test
    public void test_2() {
        assertThat(numberComplement.findComplement(1)).isEqualTo(0);
    }
}