package com.leetcode.questions;

import java.util.Arrays;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] copy = Arrays.copyOf(heights, heights.length);

        Arrays.sort(heights);

        int count = 0;

        for (int i = 0; i < heights.length; i++) {
            count += copy[i] == heights[i] ? 0 : 1;
        }

        return count;
    }
}
