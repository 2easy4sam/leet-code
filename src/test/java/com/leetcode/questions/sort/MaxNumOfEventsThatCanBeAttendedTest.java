package com.leetcode.questions.sort;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxNumOfEventsThatCanBeAttendedTest {
    private MaxNumOfEventsThatCanBeAttended maxNumOfEventsThatCanBeAttended;

    @Before
    public void setUp() {
        maxNumOfEventsThatCanBeAttended = new MaxNumOfEventsThatCanBeAttended();
    }

    @Test
    public void test_1() {
        int[][] events = new int[][]{
                {1, 2},
                {1, 2},
                {1, 2},
                {1, 2},
                {1, 6}
        };

        assertThat(maxNumOfEventsThatCanBeAttended.maxEvents(events)).isEqualTo(3);
    }

    @Test
    public void test_2() {
        int[][] events = new int[][]{
                {1, 2},
                {1, 2},
                {3, 3},
                {1, 5},
                {1, 5}
        };

        assertThat(maxNumOfEventsThatCanBeAttended.maxEvents(events)).isEqualTo(5);
    }
}