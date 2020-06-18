package com.leetcode.questions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LargestUniqueNumber {
    public int largestUniqueNumber(int[] A) {
        if (A.length == 0) return -1;

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            countMap.put(A[i], countMap.getOrDefault(A[i], 0) + 1);
        }

        return countMap
                .entrySet()
                .stream()
                .filter(entrySet -> entrySet.getValue() == 1)
                .map(entrySet -> entrySet.getKey())
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .orElse(-1);
    }
}
