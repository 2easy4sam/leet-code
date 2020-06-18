package com.leetcode.questions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        List<Integer> weights = Arrays.stream(stones)
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        while (weights.size() > 1) {
            int size = weights.size();
            int idx1 = size - 1;
            int idx2 = size - 2;
            int w1 = weights.get(idx1);
            int w2 = weights.get(idx2);

            weights.remove(idx1);
            weights.remove(idx2);

            int w3 = w1 - w2;
            if (w3 > 0) weights.add(w3);
            Collections.sort(weights);
        }

        return weights.size() > 0 ? weights.get(0) : 0;
    }

    public int lastStoneWeight2(int[] stones) {
        Arrays.sort(stones);

        for (int i = stones.length - 1; i > 0; i--) {
            if (stones[i] == stones[i - 1]) {
                if (i > 1) i--;
                else return 0;
            } else {
                stones[i - 1] = stones[i] - stones[i - 1];
                Arrays.sort(stones);
            }
        }

        return stones[0];
    }

    public int lastStoneWeight3(int[] stones) {
        // always pop out the largest number first
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        // populate queue
        for (int stone : stones) {
            pq.offer(stone);
        }

        for (int i = 0; i < stones.length - 1; ++i) {
            pq.offer(pq.poll() - pq.poll());
        }

        return pq.poll();
    }
}
