package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SortCharsByFrequencyTest {
    private SortCharsByFrequency sortCharsByFrequency;

    @Before
    public void setUp() {
        sortCharsByFrequency = new SortCharsByFrequency();
    }

    @Test
    public void test_1() {
        String s = "tree";

        assertThat(sortCharsByFrequency.frequencySort(s)).isEqualTo("eert");
    }

}