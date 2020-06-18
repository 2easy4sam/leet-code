package com.leetcode.questions.array;

public class NumOfSubArrOfSizeKWithAvgGTEQThreshold {
    /*
    Create a window of size k, move it along and sum up the elements
    along the way, subtract the values outside the window
    */
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        // sliding window
        int p = threshold * k, sum = 0, cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i < k - 1) continue;
            if (i > k - 1) sum -= arr[i - k];
            if (sum >= p) cnt++;
        }

        return cnt;
    }
}
