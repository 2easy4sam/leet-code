package com.leetcode.questions.bfs;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OpenTheLockTest {
    private OpenTheLock underTest;

    @Before
    public void setUp() {
        underTest = new OpenTheLock();
    }

    @Test
    public void test_1() {
        String[] deadends = new String[]{"8888"};
        assertThat(underTest.openLock(deadends, "0009")).isEqualTo(1);
    }
}