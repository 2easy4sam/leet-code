package com.leetcode.questions.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        for (String d : deadends) deadendSet.add(d);

        Queue<StringBuilder> q = new LinkedList<>();
        q.offer(new StringBuilder("0000"));

        int steps = 0;

        while (!q.isEmpty()) {
            final int size = q.size();

            for (int i = 0; i < size; i++) {
                StringBuilder curr = q.poll();
                if (curr.toString().equals(target)) return steps;

                for (int index = 0; index < 4; index++) {
                    StringBuilder next0 = turn(new StringBuilder(curr), index, 1);
                    StringBuilder next1 = turn(new StringBuilder(curr), index, -1);

                    if (!deadendSet.contains(next0.toString()) && visited.add(next0.toString())) q.offer(next0);
                    if (!deadendSet.contains(next1.toString()) && visited.add(next1.toString())) q.offer(next1);
                }
            }

            steps++;
        }

        return -1;
    }

    private StringBuilder turn(StringBuilder curr, int index, int inc) {
        int num = ((curr.charAt(index) - '0') + inc) % 10;
        if (num < 0) num = 9;
        curr.setCharAt(index, (char) (num + '0'));
        return curr;
    }
}