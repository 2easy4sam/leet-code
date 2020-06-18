package com.leetcode.questions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        Set set = IntStream.of(nums).boxed().collect(Collectors.toSet());

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(i)) return i;
        }

        return nums.length;
    }
}
