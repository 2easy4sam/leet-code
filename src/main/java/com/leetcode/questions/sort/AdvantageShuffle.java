package com.leetcode.questions.sort;

import java.util.*;

public class AdvantageShuffle {
    public int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer, Integer> a = new TreeMap<>();
        for (int num : A) a.put(num, a.getOrDefault(num, 0) + 1);

        int[] b = Arrays.copyOf(B, B.length);
        Arrays.sort(b);

        Map<Integer, Queue<Integer>> map = new HashMap<>();

        for (int i = b.length - 1; i >= 0; i--) {
            int num = b[i];
            Map.Entry<Integer, Integer> higher = a.higherEntry(num);
            map.putIfAbsent(num, new LinkedList<>());

            if (higher != null) {
                map.get(num).offer(higher.getKey());

                if (higher.getValue() - 1 == 0) {
                    a.remove(higher.getKey());
                } else {
                    a.put(higher.getKey(), higher.getValue() - 1);
                }
            } else {
                Map.Entry<Integer, Integer> lowest = a.firstEntry();
                map.get(num).offer(lowest.getKey());

                if (lowest.getValue() - 1 == 0) {
                    a.remove(lowest.getKey());
                } else {
                    a.put(lowest.getKey(), lowest.getValue() - 1);
                }
            }
        }

        for (int i = 0; i < B.length; i++) {
            A[i] = map.get(B[i]).poll();
        }

        return A;
    }
}
