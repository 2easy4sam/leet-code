package com.leetcode.questions.sort;

import java.util.PriorityQueue;

public class MaxNumOfEventsThatCanBeAttended {
    public int maxEvents(int[][] events) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (b[1] - a[1] != 0) {
                return b[1] - a[1];
            } else {
                return b[0] - a[0];
            }
        });

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int[] event : events) {
            pq.offer(event);
            min = Math.min(min, event[0]);
            max = Math.max(max, event[1]);
        }

        int cnt = 0;

        while (!pq.isEmpty() && max >= min) {
            if (max >= pq.peek()[0] && max <= pq.peek()[1]) {
                cnt++;
                pq.poll();
                max--;
            } else if (max < pq.peek()[0]) {
                pq.poll();
            } else if (max > pq.peek()[1]) {
                max--;
            }
        }

        return cnt;
    }
}
