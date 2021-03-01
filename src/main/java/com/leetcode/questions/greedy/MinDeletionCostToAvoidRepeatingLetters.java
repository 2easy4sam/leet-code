package com.leetcode.questions.greedy;

import java.util.PriorityQueue;

public class MinDeletionCostToAvoidRepeatingLetters {
    /*
    - intuition:
        - use two-pointer technique to find sequences with repeated chars
        - use a priority queue/min heap to record
    */
    public int minCost(String s, int[] cost) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int minCost = 0;

        for (int i, j = 0; j < s.length(); j++) {
            i = j;

            while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                pq.offer(cost[j++]);
            }

            while (pq.size() > 1) {
                minCost += pq.poll();
            }

            if (!pq.isEmpty()) pq.poll();
        }

        return minCost;
    }
}
