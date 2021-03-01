package com.leetcode.questions.greedy;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TaskSchedulerTest {
    private TaskScheduler taskScheduler;

    @Before
    public void setUp() {
        taskScheduler = new TaskScheduler();
    }

    @Test
    public void test_1() {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;

        assertThat(taskScheduler.leastInterval(tasks, n)).isEqualTo(8);
    }

    @Test
    public void test_2() {
        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int n = 2;

        assertThat(taskScheduler.leastInterval(tasks, n)).isEqualTo(16);
    }
}