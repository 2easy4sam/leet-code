package com.leetcode.questions.array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int i = 0, n = nums.length;

        for (int j = 0; j < n; j++) {
            pq.offer(nums[j]);

            if (j >= k) {
                if (nums[i] == pq.peek()) pq.remove(nums[i]);
                i++;
            }

            if (j - i + 1 == k) {
                res.add(pq.peek());
            }
        }

        int[] arr = new int[res.size()];

        for (int idx = 0; idx < res.size(); idx++) {
            arr[idx] = res.get(idx);
        }

        return arr;
    }
}
