package com.leetcode.questions;

public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits2(int n) {
        int oddMask = 1;
        int evenMask = 2;

        while (n != 0) {
            if ((n & oddMask) == (n & evenMask) >> 1) return false;
            n >>= 1;
        }

        return true;
    }

    /**
     * done with XOR
     *
     *  01010101
     * ^00010101 (bitwise right shifted by 2)
     * ---------
     *  01000000
     */
    public boolean hasAlternatingBits(int n) {
        return ((n ^= n / 4) & n - 1) == 0;
    }
}
