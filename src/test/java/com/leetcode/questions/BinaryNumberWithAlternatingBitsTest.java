package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryNumberWithAlternatingBitsTest {
    private BinaryNumberWithAlternatingBits binaryNumberWithAlternatingBits;

    @Before
    public void setUp() {
        binaryNumberWithAlternatingBits = new BinaryNumberWithAlternatingBits();
    }

    @Test
    public void test_1() {
        assertThat(binaryNumberWithAlternatingBits.hasAlternatingBits(5)).isTrue();
    }

    @Test
    public void test_2() {
        assertThat(binaryNumberWithAlternatingBits.hasAlternatingBits(7)).isFalse();
    }

    @Test
    public void test_3() {
        assertThat(binaryNumberWithAlternatingBits.hasAlternatingBits(11)).isFalse();
    }

    @Test
    public void test_4() {
        assertThat(binaryNumberWithAlternatingBits.hasAlternatingBits(10)).isTrue();
    }

    @Test
    public void test_5() {
        assertThat(binaryNumberWithAlternatingBits.hasAlternatingBits(6)).isFalse();
    }
}