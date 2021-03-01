package com.leetcode.questions.stack;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DailyTemperaturesTest {
    private DailyTemperatures dailyTemperatures;

    @Before
    public void setUp() {
        dailyTemperatures = new DailyTemperatures();
    }

    @Test
    public void test_1() {
        assertThat(dailyTemperatures.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}))
                .containsExactly(1, 1, 4, 2, 1, 1, 0, 0);
    }
}