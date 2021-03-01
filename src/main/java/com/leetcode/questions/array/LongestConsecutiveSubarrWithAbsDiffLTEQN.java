package com.leetcode.questions.array;

import java.util.PriorityQueue;

public class LongestConsecutiveSubarrWithAbsDiffLTEQN {
    public int longestSubarray(int[] nums, int limit) {
        if (nums == null || nums.length == 0) return 0;
        int len = 1, i = 0;
        PriorityQueue<Integer> minQ = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> maxQ = new PriorityQueue<>();

        for (int j = 0; j < nums.length; j++) {
            int num = nums[j];
            minQ.add(num);
            maxQ.add(num);

            while (!minQ.isEmpty() && maxQ.peek() - minQ.peek() > limit && i < j) {
                minQ.remove(nums[i]);
                maxQ.remove(nums[i]);
                i++;
            }

            len = Math.max(len, j - i + 1);
        }

        return len;
    }
}
