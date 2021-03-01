package com.leetcode.questions.array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastNumOfUniqueIntsAfterKRemovals {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr)
            map.put(num, map.getOrDefault(num, 0) + 1);

        PriorityQueue<Integer> q = new PriorityQueue<>(map.values());

        while (k != 0 && !q.isEmpty()) {
            int top = q.poll();
            if (k > top) k -= top;
            else {
                k = 0;
                top -= k;
                if (top > 0) q.offer(top);
            }
        }

        return q.size();
    }
}
