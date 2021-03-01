package com.leetcode.questions.array;

public class SubarrProductLTK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = 1, n = nums.length, cnt = 0, marker = -1;

        // j - i + 1
        int i = 0, j = 0;

        while (j < n) {
            product *= nums[j];

            if (product >= k) {
                if (marker >= i) {
                    // remove the overlapping count
                    cnt -= countCombos(marker - i + 1);
                }
                marker = Math.min(0, j - 1);
                cnt += countCombos(j - i);

                while (product >= k && i < j) {
                    product /= nums[i];
                    i++;
                }
            }

            j++;
        }

        if (product < k) {
            if (marker >= i) cnt -= countCombos(marker - i + 1);
            // product is less than k and we have reached the end
            cnt += countCombos(j - i);
        }

        return cnt;
    }

    private int countCombos(int n) {
        if (n <= 1) return n;
        int cnt = n + 1, inc = 2;

        while (n > 2) {
            cnt += inc;
            n--;
            inc++;
        }

        return cnt;
    }
}
