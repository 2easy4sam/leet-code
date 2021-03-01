package com.leetcode.questions.array;

public class BinarySubarraysWithSum {

    public int numSubarraysWithSum(int[] A, int S) {
        int cnt = 0, i = 0, j = 0, n = A.length, sum = 0;

        while (j < n) {
            sum += A[j++];
            if (sum == S) cnt++;

            while (sum > S || A[i] == 0) {
                sum -= A[i++];
                if (sum == S) cnt++;
            }
        }

        return cnt;
    }
}
