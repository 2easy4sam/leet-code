package com.leetcode.questions;

public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int total = 0, n = nums.length;

        // an integer has at most 32 bits
        // the idea is that we bitwise shift to the right
        // by n bits at a time (1 - 31), checking each
        // bit position in each number
        // if all numbers have a bit position, then this bit
        // does not contribute to the total count
        // in other words, numbers that don't have a particular
        // bit will contribute to the total count
        // This is because that we would normally calculate the difference
        // in bits between two numbers by using bitwise XOR
        for (int i = 0; i < 32; i++) {
            int k = 0;

            for (int num : nums) {
                k += (num >> i) & 1;
            }

            // k numbers have the bit
            // n - k numbers don't have
            // they make up k * (n - k) pairs
            // that contribute to the total
            total += k * (n - k);
        }

        return total;
    }
}
