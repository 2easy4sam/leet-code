package com.leetcode.questions;

public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num < 2) return false;

        int sum = 0;

        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i + num / i % num;
            }
        }

        return sum == num;
    }
}
