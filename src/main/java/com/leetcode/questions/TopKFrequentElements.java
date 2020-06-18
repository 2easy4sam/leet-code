package com.leetcode.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> answer = new ArrayList<>();

        // bucket sort
        int n = nums.length;
        // create n empty buckets
        // supposing each num is unique, there can be a maximum of n buckets
        // + 1 because if the array contains a single num, the occurrences is n + 1
        List<Integer>[] buckets = new List[n + 1];
        // count occurrences of each num
        Map<Integer, Integer> frequencies = new HashMap<>();

        for (int num : nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }

        // distribute elements to buckets
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            int frequency = entry.getValue();
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            // add the number
            buckets[frequency].add(entry.getKey());
        }

        // find the first k largest buckets
        for (int i = buckets.length - 1; i > 0 && answer.size() < k; i--) {
            if (buckets[i] != null) {
                answer.addAll(buckets[i]);
            }
        }

        return answer;
    }
}
