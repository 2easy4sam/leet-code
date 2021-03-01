package com.leetcode.questions.array;

/*
TODO: look up the answer and try to implement it
*/
public class ShortestSubArrWithSumAtLeastK {

    public int shortestSubarray(int[] A, int K) {
        // sliding window
        int n = A.length, i = 0, j, k = n, min = n, sum1 = 0, sum2 = 0;
        boolean exists = false;

        for (j = 0; j < n; j++) {
            if (j > 0 && A[j - 1] < 0 && A[j] >= 0) k = j;
            if (k <= j) sum2 += A[j];

            sum1 += A[j];

            while (sum1 >= K && i < n) {
                exists = true;
                min = Math.min(min, j - i + 1);
                sum1 -= A[i++];
            }

            while (sum2 >= K && k < j) {
                exists = true;
                min = Math.min(min, j - k + 1);
                sum2 -= A[k++];
            }
        }

        return exists ? min : -1;
    }
}
