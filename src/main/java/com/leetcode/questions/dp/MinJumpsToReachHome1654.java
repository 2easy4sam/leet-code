package com.leetcode.questions.dp;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinJumpsToReachHome1654 {
    /*
    - keynotes:
        - at each position along the x-axis, we can perform one of the two following ops:
            - jump forward
            - jump backward
        - stop conditions:
            - the bug is beyond x at position y AND (y - x) > b
            - the bug is at position x
            - the bug is at a negative position
    */
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> notAllowed = new HashSet<>();
        // since we can't jump back twice in a row
        int n = x + 2 * b;
        for (int v : forbidden) {
            notAllowed.add(v);
            n = Math.max(n, v + 2 * b);
        }

        Set<Integer> forwardJumps = new HashSet<>();
        Set<Integer> backwardJumps = new HashSet<>();

        // steps, pos, dir[0: forward, 1: backward]
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> i1[0] - i2[0]);
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int jumps = curr[0], i = curr[1], dir = curr[2];

            if (i == x) return jumps;

            int j = i + a, k = i - b;

            // moving forward. need to make sure the bug has never jumped backward to j
            if (j < n && !notAllowed.contains(j) && forwardJumps.add(j)) {
                pq.offer(new int[]{jumps + 1, j, 0});
            }

            if (dir != 1 && k >= 0 && !notAllowed.contains(k) && backwardJumps.add(k)) {
                pq.offer(new int[]{jumps + 1, k, 1});
            }
        }

        return -1;
    }
}