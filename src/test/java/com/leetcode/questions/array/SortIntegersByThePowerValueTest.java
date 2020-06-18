package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SortIntegersByThePowerValueTest {
    private SortIntegersByThePowerValue sortIntegersByThePowerValue;

    @Before
    public void setUp() {
        sortIntegersByThePowerValue = new SortIntegersByThePowerValue();
    }

    @Test
    public void test_1() {
        assertThat(sortIntegersByThePowerValue.getKth(12, 15, 2)).isEqualTo(13);
    }

    @Test
    public void test_2() {
        assertThat(sortIntegersByThePowerValue.getKth(7, 11, 4)).isEqualTo(7);
    }
}