package com.leetcode.questions.array;

import java.util.HashMap;
import java.util.Map;

public class MaxSizeSubarrSumEqualsK325 {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> prefixLen = new HashMap<>();

        int prefix = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];

            if (prefix == k) {
                if (i + 1 > max) max = i + 1;
            }

            if (prefixLen.containsKey(prefix - k)) {
                max = Math.max(max, i + 1 - prefixLen.get(prefix - k));
            }

            if (!prefixLen.containsKey(prefix)) {
                prefixLen.put(prefix, i + 1);
            }
        }

        return max;
    }
}
