package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PowerOfFourTest {
    private PowerOfFour powerOfFour;

    @Before
    public void setUp() {
        powerOfFour = new PowerOfFour();
    }

    @Test
    public void test_1() {
        assertThat(powerOfFour.isPowerOfFour(1)).isTrue();
    }

    @Test
    public void test_2() {
        assertThat(powerOfFour.isPowerOfFour(4)).isTrue();
    }

    @Test
    public void test_3() {
        assertThat(powerOfFour.isPowerOfFour(16)).isTrue();
    }

    @Test
    public void test_4() {
        assertThat(powerOfFour.isPowerOfFour(64)).isTrue();
    }

    @Test
    public void test_5() {
        assertThat(powerOfFour.isPowerOfFour(5)).isFalse();
    }

    @Test
    public void test_6() {
        assertThat(powerOfFour.isPowerOfFour(8)).isFalse();
    }

    @Test
    public void test_7() {
        assertThat(powerOfFour.isPowerOfFour(20)).isFalse();
    }

    @Test
    public void test_8() {
        assertThat(powerOfFour.isPowerOfFour(12)).isFalse();
    }
}