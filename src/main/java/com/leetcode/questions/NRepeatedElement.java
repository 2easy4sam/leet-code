package com.leetcode.questions;

public class NRepeatedElement {

    public int repeatedNTimes(int[] A) {
        int[] counts = new int[10000];

        for (int i : A) {
            if (counts[i]++ == 1) return i;
        }

        throw new IllegalArgumentException();
    }
}
