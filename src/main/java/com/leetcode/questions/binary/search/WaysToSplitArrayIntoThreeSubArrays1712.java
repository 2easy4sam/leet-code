package com.leetcode.questions.binary.search;

public class WaysToSplitArrayIntoThreeSubArrays1712 {
    /*
    - calculate prefix sum array for getting subarray sums later
    - two-pointer i and j
        - move j from right to left
        - calculate i using binary search
    */
    public int waysToSplit(int[] nums) {
        final int mod = (int) 1e9 + 7;
        int preSum = 0, n = nums.length;
        int[] prefix = new int[n];

        for (int i = 0; i < n; i++) {
            preSum += nums[i];
            prefix[i] = preSum;
        }

        int cnt = 0;

        for (int i = 1; i < n - 1; i++) {
            int left = prefix[i - 1];

            int leftBound = binarySearch(prefix, i, left, true);
            int rightBound = binarySearch(prefix, i, left, false);

            if (leftBound == -1 || rightBound == -1) continue;

            cnt = cnt + (rightBound - leftBound + 1);
            cnt %= mod;
        }

        return cnt;
    }

    private int binarySearch(int[] prefix, int i, int left, boolean searchLeft) {
        int l = i, r = prefix.length - 2, idx = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            int middle = prefix[mid] - left;
            int right = prefix[prefix.length - 1] - left - middle;

            if (left <= middle && middle <= right) {
                idx = mid;
                if (searchLeft) r = mid - 1;
                else l = mid + 1;
            } else if (left > middle) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return idx;
    }
}
