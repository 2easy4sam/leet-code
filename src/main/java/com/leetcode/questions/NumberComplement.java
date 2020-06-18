package com.leetcode.questions;

public class NumberComplement {
    public int findComplement(int num) {
        String binaryStr = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < binaryStr.length(); i++) {
            sb.append("1");
        }

        return num ^ Integer.parseInt(sb.toString(), 2);
    }
}
