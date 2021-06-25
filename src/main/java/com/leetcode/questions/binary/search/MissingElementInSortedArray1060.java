package com.leetcode.questions.binary.search;

import java.util.HashSet;
import java.util.Set;

public class MissingElementInSortedArray1060 {
    public int missingElement(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) set.add(num);

        int n = nums.length, nMissing = nums[n - 1] - nums[0] + 1 - n;

        if (k > nMissing) return nums[n - 1] + k - nMissing;

        int l = nums[0], r = nums[n - 1];

        while (l <= r) {
            int mid = l + (r - l) / 2;

            // calculate the distance between mid and nums[0]
            int dist = mid - l;

            if (!set.contains(mid)) {
                if (dist == k || dist == 0) return mid;

                if (dist > k) {
                    /*
                    now that we know between l and mid, there's dist numbers, assuming there's no
                    missing numbers. However, we already know that mid does not exist, so we have at most
                    dist - 1 numbers between l (exclusive) and mid (inclusive)
                    */

                    if (mid - l - 1 == k) return mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                // mid exists in nums
                if (dist > k) {
                    r = mid - 1;
                } else {
                    if (dist == k) {
                        nMissing = mid - l;
                        k -= nMissing;
                    }

                    l = mid + 1;
                }
            }
        }

        return -1;
    }
}
