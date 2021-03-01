package com.leetcode.questions.sort;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InsertIntervalTest {
    private InsertInterval insertInterval;

    @Before
    public void setUp() {
        insertInterval = new InsertInterval();
    }

    @Test
    public void test_1() {
        int[][] intervals = new int[][]{
                {1, 3},
                {6, 9}
        };

        int[] newInterval = new int[]{2, 5};

        assertThat(insertInterval.insert(intervals, newInterval))
                .contains(new int[]{1, 5}, new int[]{6, 9});
    }
}