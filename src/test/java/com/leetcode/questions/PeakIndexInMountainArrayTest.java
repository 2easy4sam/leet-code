package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PeakIndexInMountainArrayTest {
    private PeakIndexInMountainArray peakIndexInMountainArray;

    @Before
    public void setUp() {
        peakIndexInMountainArray = new PeakIndexInMountainArray();
    }

    @Test
    public void test() {
        int[] a = new int[]{0, 2, 1, 0};

        int idx = peakIndexInMountainArray.peakIndexInMountainArray(a);

        assertThat(idx).isEqualTo(1);
    }
}