package com.leetcode.questions.backtracking;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxLenOfConcatStrWithUniqueCharsTest {
    private MaxLenOfConcatStrWithUniqueChars maxLenOfConcatStrWithUniqueChars;

    @Before
    public void setUp() {
        maxLenOfConcatStrWithUniqueChars = new MaxLenOfConcatStrWithUniqueChars();
    }

    @Test
    public void test_1() {
        List<String> arr = new ArrayList<>();
        arr.add("yy");
        arr.add("bkhwmpbiisbldzknpm");

        assertThat(maxLenOfConcatStrWithUniqueChars.maxLength(arr)).isEqualTo(0);
    }
}