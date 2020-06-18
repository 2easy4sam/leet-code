package com.leetcode.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class IsMajorityElement {
    public boolean isMajorityElement(int[] nums, int target) {
        Map<Integer, Integer> numCountMap = new HashMap<>();

        for (int num : nums) {
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
        }

        return Optional.ofNullable(numCountMap.get(target)).orElse(0) > nums.length / 2;
    }
}
