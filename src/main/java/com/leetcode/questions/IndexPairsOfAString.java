package com.leetcode.questions;

import java.util.ArrayList;
import java.util.List;

public class IndexPairsOfAString {
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> res = new ArrayList();

        for (int i = 0; i < text.length(); i++) {
            for (int j = i; j < text.length(); j++) {
                String subStr = text.substring(i, j + 1);

                for (String word : words) {
                    if (subStr.equals(word)) {
                        res.add(new int[]{i, j});
                    }
                }
            }
        }

        return res.stream().toArray(int[][]::new);
    }
}
