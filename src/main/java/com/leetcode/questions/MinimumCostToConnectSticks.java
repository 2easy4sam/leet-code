package com.leetcode.questions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {

    public int connectSticks(int[] sticks) {

        int cost = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(a -> a));

        for (int stick : sticks) {
            q.offer(stick);
        }

        while (q.size() > 1) {
            Integer num1 = q.poll();
            Integer num2 = q.poll();

            int sum = num1 + num2;
            q.offer(sum);
            cost += sum;
        }

        return cost;
    }
}
