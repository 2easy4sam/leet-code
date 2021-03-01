package com.leetcode.questions.backtracking;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AdditiveNumberTest {
    private AdditiveNumber additiveNumber;

    @Before
    public void setUp() {
        additiveNumber = new AdditiveNumber();
    }

    @Test
    public void test_1() {
        String num = "000";

        assertThat(additiveNumber.isAdditiveNumber(num)).isTrue();
    }

    @Test
    public void test_2() {
        String num = "211738";

        assertThat(additiveNumber.isAdditiveNumber(num)).isTrue();
    }

    @Test
    public void test_3() {
        String num = "12122436";

        assertThat(additiveNumber.isAdditiveNumber(num)).isTrue();
    }
}