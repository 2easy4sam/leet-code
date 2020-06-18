package com.leetcode.questions.array;

public class GrumpyBookstoreOwner {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        // 1. iterate through both arrays and calculate sum with X = 0
        // 2. create a window of size X and slide through customers & grumpy
        // work out the max difference
        int n = customers.length;

        int s1 = 0, s2 = 0, maxDiff = 0;
        for (int i = 0; i < n; i++) {
            s1 += grumpy[i] == 1 ? 0 : customers[i];
            s2 += customers[i];

            if (i > X - 1) {
                s1 -= grumpy[i - X] == 1 ? 0 : customers[i - X];
                s2 -= customers[i - X];
            }

            if (i >= X - 1) {
                maxDiff = Math.max(maxDiff, s2 - s1);
            }
        }

        return s1 + maxDiff;
    }
}
