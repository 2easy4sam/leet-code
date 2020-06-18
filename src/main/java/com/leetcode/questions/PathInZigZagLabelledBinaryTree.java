package com.leetcode.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathInZigZagLabelledBinaryTree {
    public List<Integer> pathInZigZagTree(int label) {
        boolean ltr = true, foundLabel = false;
        int n = 1, idx = 0, curLevel = 0, val = 1;

        List<int[]> levels = new ArrayList<>();

        while (!foundLabel) {
            curLevel++;
            int[] level = new int[n];

            for (int i = 0, j = n - 1; i < n; i++, j--) {
                level[ltr ? i : j] = val;

                if (val == label) {
                    foundLabel = true;
                    idx = ltr ? i : j;
                }
                val++;
            }

            n *= 2;
            ltr = !ltr;
            levels.add(level);
        }

        Integer[] res = new Integer[curLevel];

        while (curLevel-- != 0) {
            int[] lastLevel = levels.get(curLevel);
            res[curLevel] = lastLevel[idx];
            idx = (idx + 2) / 2 - 1;
        }

        return Arrays.asList(res);
    }
}
