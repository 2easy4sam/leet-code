package com.leetcode.questions.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallestCommonRegionTest {
    private SmallestCommonRegion smallestCommonRegion;

    @Before
    public void setUp() {
        smallestCommonRegion = new SmallestCommonRegion();
    }

    @Test
    public void test_1() {
        List<List<String>> regions = new ArrayList<>();
        regions.add(Arrays.asList("Earth","North America","South America"));
        regions.add(Arrays.asList("North America","United States","Canada"));
        regions.add(Arrays.asList("United States","New York","Boston"));
        regions.add(Arrays.asList("Canada","Ontario","Quebec"));
        regions.add(Arrays.asList("South America","Brazil"));

    }
}