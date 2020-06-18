package com.leetcode.questions;

public class SumOfDigitsInTheMinimumNumber {

    public int sumOfDigits(int[] A) {
        int minNum = A[0];
        int sum = 0;

        for (int i : A) {
            if (i < minNum) minNum = i;
        }

        while (minNum > 0) {
            sum += minNum % 10;
            minNum /= 10;
        }

        return sum % 2 == 1 ? 0 : 1;
    }
}
