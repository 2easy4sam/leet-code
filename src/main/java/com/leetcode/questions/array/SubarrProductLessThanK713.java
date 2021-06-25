package com.leetcode.questions.array;

public class SubarrProductLessThanK713 {
    /*
    - use two-pointer
    */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int prefix = 1, total = 0, i = 0, j = 0, r = 0;

        while (i < nums.length && j < nums.length) {
            prefix *= nums[j];

            if (prefix >= k) {
                total += countSubarrs(j - i);
                total -= countSubarrs(r - i);
                r = j;

                while (i < nums.length && prefix >= k) {
                    prefix /= nums[i++];
                }
            }

            j++;
        }

        if (prefix < k) {
            total += countSubarrs(j - i);
            total -= countSubarrs(r - i);
        }

        return total;
    }

    private int countSubarrs(int len) {
        int cnt = 0;
        if (len < 1) return 0;

        while (len > 0) {
            cnt += len--;
        }

        return cnt;
    }
}
