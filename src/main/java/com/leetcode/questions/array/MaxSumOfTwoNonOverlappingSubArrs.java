package com.leetcode.questions.array;

public class MaxSumOfTwoNonOverlappingSubArrs {

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int max1 = helper(A, L, M);
        int max2 = helper(A, M, L);

        return Math.max(max1, max2);
    }

    private int helper(int[] A, int L, int M) {
        int max = 0;

        // sliding window algorithm
        int s1 = 0;
        for (int i = 0; i < A.length - M; i++) {
            s1 += A[i];
            if (i < L) continue;
            if (i > L - 1) s1 -= A[i - L];

            int s2 = 0;
            for (int j = i + 1; j < A.length; j++) {
                s2 += A[j];
                if (j - i < M) continue;
                if (j - i > M) s2 -= A[j - M];

                max = Math.max(max, s1 + s2);
            }
        }

        return max;
    }
}
