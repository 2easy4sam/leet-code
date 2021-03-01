package com.leetcode.questions.array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int n = q.size();

            while (n-- > 0) {
                int curr = q.poll();
                if (arr[curr] == 0) return true;
                if (visited.contains(curr)) continue;
                if (curr + arr[curr] < arr.length && visited.add(curr + arr[curr])) {
                    q.offer(curr + arr[curr]);
                }

                if (curr - arr[curr] >= 0 && visited.add(curr - arr[curr])) {
                    q.offer(curr - arr[curr]);
                }

                visited.add(curr);
            }
        }

        return false;
    }
}
