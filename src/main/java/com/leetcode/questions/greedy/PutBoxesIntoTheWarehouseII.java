package com.leetcode.questions.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PutBoxesIntoTheWarehouseII {

    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int m = boxes.length, n = warehouse.length;
        int[] l2r = new int[n];
        int[] r2l = new int[n];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, warehouse[i]);
            l2r[i] = min;
        }

        min = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            min = Math.min(min, warehouse[i]);
            r2l[i] = min;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int box : boxes) pq.offer(box);

        for (int i = 0; i < n; i++) {
            warehouse[i] = Math.max(l2r[i], r2l[i]);
        }

        Arrays.sort(warehouse);

        int cnt = 0;

        for (int i = 0; i < n && !pq.isEmpty(); i++) {
            if (pq.peek() <= warehouse[i]) {
                pq.poll();
                cnt++;
            }
        }

        return cnt;
    }
}
