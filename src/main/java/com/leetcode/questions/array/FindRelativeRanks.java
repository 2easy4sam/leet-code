package com.leetcode.questions.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindRelativeRanks {

    public String[] findRelativeRanks(int[] nums) {
        /*
        - sort the scores in desc order (O(nlogn))
            - first 3 are gold, silver and bronze
        */
        int n = nums.length;
        String[] output = new String[n];
        int[] copy = new int[n];
        System.arraycopy(nums, 0, copy, 0, n);

        Map<Integer, String> map = new HashMap<>();

        Arrays.sort(copy);

        for (int i = n - 1, idx = 0; i >= 0; i--) {
            if (i == n - 1) {
                map.put(copy[idx], "Gold Medal");
            } else if (i == n - 2) {
                map.put(copy[idx], "Silver Medal");
            } else if (i == n - 3) {
                map.put(copy[idx], "Bronze Medal");
            } else {
                map.put(copy[idx], n - i + "");
            }

            idx++;
        }

        for (int i = 0; i < n; i++) {
            output[i] = map.get(nums[i]);
        }

        return output;
    }
}
