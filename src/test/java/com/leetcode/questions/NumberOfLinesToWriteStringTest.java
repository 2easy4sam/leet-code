package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberOfLinesToWriteStringTest {
    private NumberOfLinesToWriteString numberOfLinesToWriteString;

    @Before
    public void setUp() {
        numberOfLinesToWriteString = new NumberOfLinesToWriteString();
    }

    @Test
    public void test_1() {
        int[] widths = new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String str = "abcdefghijklmnopqrstuvwxyz";

        assertThat(numberOfLinesToWriteString.numberOfLines(widths, str)).containsExactly(3, 60);
    }

    @Test
    public void test_2() {
        int[] widths = new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String str = "bbbcccdddaaa";

        assertThat(numberOfLinesToWriteString.numberOfLines(widths, str)).containsExactly(2, 4);
    }
}