package com.leetcode.questions.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
TODO: use DP to solve this problem
*/
public class MaxLenOfRepeatedSubarr {

    public int findLength(int[] A, int[] B) {
        // number <-> list of indexes
        Map<Integer, List<Integer>> map = new HashMap<>();
        int max = 0;

        // O(n)
        for (int i = 0; i < B.length; i++) {
            int num = B[i];
            List<Integer> indexes = map.getOrDefault(num, new ArrayList<>());
            indexes.add(i);
            map.put(num, indexes);
        }

        for (int i = 0; i < A.length; i++) {
            int num = A[i];

            if (map.containsKey(num)) {
                List<Integer> indexes = map.get(num);

                for (int index : indexes) {
                    int tmp = i;
                    int cnt = 0;

                    while (tmp < A.length
                            && index < B.length
                            && A[tmp++] == B[index++]) {
                        cnt++;
                    }
                    max = Math.max(max, cnt);
                }
            }
        }

        return max;
    }
}
