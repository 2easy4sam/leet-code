package com.leetcode.questions.greedy;

import java.util.*;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        /*
        - priority queue to keep track of idle time
        - hash map to keep track of the number of each task
        - base case: n == 0, return the size of the array
        - always pick the task that has the largest number and is not in idle first
        */

        if (n == 0) return tasks.length;

        Map<Character, Integer> taskMap = new HashMap<>();
        PriorityQueue<Integer> execQ = new PriorityQueue<>((a, b) -> b - a);
        // task cnt <-> idle units
        Queue<int[]> idleQ = new LinkedList<>();

        for (char task : tasks)
            taskMap.put(task, taskMap.getOrDefault(task, 0) + 1);

        for (int cnt : taskMap.values()) execQ.offer(cnt);

        int t = 0;

        while (!execQ.isEmpty() || !idleQ.isEmpty()) {
            int idleCnt = idleQ.size();

            while (idleCnt != 0) {
                int[] idleTask = idleQ.poll();

                if (--idleTask[1] < 0) {
                    execQ.offer(idleTask[0]);
                } else {
                    idleQ.offer(idleTask);
                }

                idleCnt--;
            }

            if (!execQ.isEmpty()) {
                int task = execQ.poll();
                task--;
                if (task > 0) {
                    idleQ.offer(new int[]{task, n});
                }
            }

            t++;
        }

        return t;
    }
}
