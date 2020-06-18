package com.leetcode.questions;

public class ShortestDistanceToChar {
    public int[] shortestToChar(String S, char C) {
        int[] res = new int[S.length()];

        int prevIdx, curIdx = -1;

        for (int i = 0, j = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                prevIdx = curIdx;
                curIdx = i;

                if (prevIdx >= 0) {
                    while (j < i) {
                        res[j] = Math.min(curIdx - j, Math.abs(prevIdx - j));
                        j++;
                    }
                } else {
                    while (j < i) {
                        res[j] = curIdx - j;
                        j++;
                    }
                }
            } else if (i == S.length() - 1 && curIdx != i) {
                while (j < S.length()) {
                    res[j] = Math.abs(curIdx - j);
                    j++;
                }
            }
        }

        return res;
    }
}
