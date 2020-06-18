package com.leetcode.questions;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            boolean divisible = true;
            int temp = i;

            while (temp != 0 && divisible) {
                int num = temp % 10;
                if (num == 0) {
                    divisible = false;
                    break;
                }
                divisible = i % num == 0;
                temp /= 10;
            }

            if (divisible) numbers.add(i);
        }

        return numbers;
    }
}
