package com.leetcode.questions.design;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyCalendarIITest {
    private MyCalendarII underTest;

    @Before
    public void setUp() {
        underTest = new MyCalendarII();
    }

    @Test
    public void test_1() {
        assertThat(underTest.book(10, 20)).isTrue();
        assertThat(underTest.book(50, 60)).isTrue();
        assertThat(underTest.book(10, 40)).isTrue();
    }
}