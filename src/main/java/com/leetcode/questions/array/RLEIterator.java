package com.leetcode.questions.array;

import java.util.LinkedList;
import java.util.Queue;

public class RLEIterator {

    private Queue<Integer> sequence;

    public RLEIterator(int[] A) {
        int n = A.length;
        sequence = new LinkedList<>();

        for (int i = 0; i < n; i += 2) {
            int cnt = A[i];
            int num = A[i + 1];

            while (cnt != 0) {
                sequence.offer(num);
                cnt--;
            }
        }
    }

    public int next(int n) {
        while (n != 0 && !sequence.isEmpty()) {
            sequence.poll();
            n--;
        }

        return sequence.isEmpty() ? -1 : sequence.peek();
    }
}
