package com.leetcode.questions.sort;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int[] interval : intervals) pq.offer(interval);

        boolean merge = false;
        int check = 0;

        Queue<int[]> cache = new LinkedList<>();

        while (!pq.isEmpty() && pq.peek()[0] <= newInterval[1]) {
            int[] top = pq.poll();

            if (check == 0 && newInterval[0] >= top[0] && newInterval[0] <= top[1]) {
                newInterval[0] = top[0];
                merge = true;
                check++;
            } else if (check == 1 && newInterval[1] >= top[0] && newInterval[1] <= top[1]) {
                newInterval[1] = top[1];
                merge = true;
                check++;
            }

            cache.offer(top);
        }

        pq.offer(newInterval);

        if (!merge) {
            while (!cache.isEmpty()) pq.offer(cache.poll());
        }

        int[][] res = new int[pq.size()][2];
        int idx = 0;
        while (!pq.isEmpty()) res[idx++] = pq.poll();
        return res;
    }
}
