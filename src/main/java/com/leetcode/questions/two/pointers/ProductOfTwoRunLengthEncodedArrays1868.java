package com.leetcode.questions.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductOfTwoRunLengthEncodedArrays1868 {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<int[]> numFreqs = new ArrayList<>();

        int i = 0, j = 0;
        int len1 = encoded1.length, len2 = encoded2.length;

        while (i < len1 && j < len2) {
            int freq1 = encoded1[i][1], freq2 = encoded2[j][1];
            int p = encoded1[i][0] * encoded2[j][0];

            if (freq1 == freq2) {
                numFreqs.add(new int[]{p, freq1});
                i++;
                j++;
            } else if (freq1 < freq2) {
                numFreqs.add(new int[]{p, freq1});
                encoded2[j][1] -= freq1;
                i++;
            } else {
                numFreqs.add(new int[]{p, freq2});
                encoded1[i][1] -= freq2;
                j++;
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        int[] prev = numFreqs.get(0);

        for (i = 1; i < numFreqs.size(); i++) {
            int[] cur = numFreqs.get(i);
            if (cur[0] != prev[0]) {
                ans.add(Arrays.asList(prev[0], prev[1]));
                prev = cur;
            } else {
                prev[1] += cur[1];
            }
        }

        ans.add(Arrays.asList(prev[0], prev[1]));

        return ans;
    }
}
