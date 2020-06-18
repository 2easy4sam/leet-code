package com.leetcode.questions;

import java.util.Arrays;

public class SumOfEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int nQueries = queries.length;
        int[] sums = new int[nQueries];

        int sum = Arrays.
                stream(A)
                .filter(num -> num % 2 == 0)
                .sum();

        for (int i = 0; i < nQueries; i++) {
            int[] query = queries[i];
            int val = query[0];
            int idx = query[1];

            int oldVal = A[idx];
            int newVal = val + oldVal;
            A[idx] = newVal;

            // was even and is odd now
            // was odd and is even now
            // was odd and still odd
            // was even and still even
            if (oldVal % 2 == 0 && newVal % 2 != 0) {
                sum -= oldVal;
            } else if (oldVal % 2 != 0 && newVal % 2 == 0) {
                sum += newVal;
            } else if (oldVal % 2 == 0 && newVal % 2 == 0) {
                sum += val;
            }

            sums[i] = sum;
        }

        return sums;
    }
}
