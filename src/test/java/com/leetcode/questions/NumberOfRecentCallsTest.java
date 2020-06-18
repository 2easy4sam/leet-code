package com.leetcode.questions;

import com.leetcode.questions.NumberOfRecentCalls.RecentCounter;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberOfRecentCallsTest {
    private RecentCounter recentCounter;

    @Before
    public void setUp() {
        recentCounter = new RecentCounter();
    }

    @Test
    public void test_1() {

        assertThat(recentCounter.ping(1)).isEqualTo(1);
        assertThat(recentCounter.ping(100)).isEqualTo(2);
        assertThat(recentCounter.ping(3001)).isEqualTo(3);
        assertThat(recentCounter.ping(3002)).isEqualTo(3);
    }
}