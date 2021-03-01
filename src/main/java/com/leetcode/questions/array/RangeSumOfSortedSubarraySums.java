package com.leetcode.questions.array;

import java.util.Arrays;

public class RangeSumOfSortedSubarraySums {

    public int rangeSum(int[] nums, int n, int left, int right) {
        /*
        - test cases:
            -   [1,2,3,4]
                window              sum array
                [[1],2,3,4]         [1]
                [[1,2],3,4]         [1,3]
                [[1,2,3],4]         [1,3,6]
                [[1,2,3,4]]         [1,3,6,10]
                [1,[2],3,4]         [1,2,3,6,10]
                [1,[2,3],4]         [1,2,3,5,6,10]
                [1,[2,3,4]]         [1,2,3,5,6,9,10]
                [1,2,[3],4]         [1,2,3,3,5,6,9,10]
                [1,2,[3,4]]         [1,2,3,3,5,6,7,9,10]
                [1,2,3,[4]]         [1,2,3,3,4,5,6,7,9,10]

                prefix sum array
                [1,3,6,10]

        - time & space complexity:
            - time:
                - create prefix sum array:              O(n)
                - work out the sums of all subarrays:   O(n)
        - thinking out loud:
            - construct a prefix sum array, use it to calculate the sum of all subarrays
            - use a new array to hold the sums of all subarrays and sort it in the end

        - constraints/key words:
            - POSITIVE integers nums[i] >= 1
            - NON-EMPTY
            - CONTINUOUS subarrays
            - sum array should be SORTED in NON-DECREASING order
        */
        int mod = 1000000007;
        int[] prefixSums = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            prefixSums[i] = sum;
        }
        int idx = 0;
        int[] sums = new int[n * (n + 1) / 2];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sums[idx++] = prefixSums[j] - (i - 1 < 0 ? 0 : prefixSums[i - 1]);
            }
        }

        Arrays.sort(sums);

        int ans = 0;
        for (int i = left - 1; i < right; i++) {
            ans += sums[i];
        }

        return ans;
    }
}
