package com.leetcode.algorithms.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BucketSort {
    public void sort(int[] nums, int nBuckets) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("nums cannot be null");
        }

        // 1. initialise buckets
        // 2. find the max num
        // 3. distribute elements to buckets
        // 4. sort each individual bucket
        // 5. combine sorted arrays

        List<List<Integer>> buckets = new ArrayList<>(nBuckets);
        for (int i = 0; i < nBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        int max = findMax(nums);

        for (int num : nums) {
            int bucketIdx = hash(num, max, nBuckets);
            buckets.get(bucketIdx).add(num);
        }

        for (List<Integer> bucket : buckets) {
            if (bucket != null)
                bucket.sort(Comparator.naturalOrder());
        }

        int i = 0;
        for (List<Integer> bucket : buckets) {
            for (int num : bucket) {
                nums[i++] = num;
            }
        }
    }

    private int findMax(int[] nums) {
        int max = nums[0];

        for (int num : nums) {
            max = Math.max(max, num);
        }

        return max;
    }

    /**
     * Returns the bucket index
     */
    private int hash(int num, int max, int nBuckets) {
        return (int) ((double) num / max * (nBuckets - 1));
    }
}
