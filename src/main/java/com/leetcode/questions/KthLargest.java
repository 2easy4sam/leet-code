package com.leetcode.questions;

import java.util.PriorityQueue;

public class KthLargest {

    private int k;
    private PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;

        for (int num : nums) add(num);
    }

    public int add(int val) {
        if (pq.size() < k) {
            pq.offer(val);
        } else if (pq.peek() < val) {
            pq.poll();
            pq.offer(val);
        }

        return pq.peek();
    }
}
