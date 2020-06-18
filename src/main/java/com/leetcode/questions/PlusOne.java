package com.leetcode.questions;

import java.util.ArrayList;
import java.util.List;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carryOver = 1;
        List<Integer> sum = new ArrayList<>();

        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i] + carryOver;

            if (digit > 9) {
                carryOver = 1;
                digit = 0;
            } else {
                carryOver = 0;
            }

            sum.add(0, digit);
        }

        if (carryOver == 1) sum.add(0, 1);

        return sum.stream().mapToInt(i -> i).toArray();
    }

    public int[] plusOne2(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (++digits[i] < 10) {
                return digits;
            }

            digits[i] = 0;
        }

        int[] sum = new int[1 + n];
        sum[0] = 1;
        return sum;
    }
}
