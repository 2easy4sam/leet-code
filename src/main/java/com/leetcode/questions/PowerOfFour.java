package com.leetcode.questions;

public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        return Integer.bitCount(num) == 1 && (Integer.toBinaryString(num).length() - 1) % 2 == 0;
    }
}
