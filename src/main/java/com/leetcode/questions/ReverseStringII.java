package com.leetcode.questions;

public class ReverseStringII {

    public String reverseStr(String s, int k) {
        char[] charArr = s.toCharArray();
        int n = 0, lowerBound = 0;

        for (int i = 0, j = Math.min(charArr.length, n * 2 * k + k) - 1; lowerBound < charArr.length && j < charArr.length; i++) {

            if (i >= lowerBound && i < j) {
                char tmp = charArr[i];
                charArr[i] = charArr[j];
                charArr[j] = tmp;
                j--;
            }

            if (i == j) {
                lowerBound = ++n * 2 * k;
                j = Math.min(charArr.length, lowerBound + k) - 1;
            }
        }

        return new String(charArr);
    }
}
