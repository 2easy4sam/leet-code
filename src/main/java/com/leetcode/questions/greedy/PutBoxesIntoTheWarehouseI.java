package com.leetcode.questions.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PutBoxesIntoTheWarehouseI {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int min = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a));

        for (int i = 0; i < warehouse.length; i++) {
            min = Math.min(min, warehouse[i]);
            warehouse[i] = min;
        }

        for (int box : boxes) {
            pq.offer(box);
        }

        int cnt = 0;
        for (int i = warehouse.length - 1; i >= 0 && !pq.isEmpty(); i--) {
            int height = warehouse[i];

            if (pq.peek() <= height) {
                pq.poll();
                cnt++;
            }
        }

        return cnt;
    }
}
