package com.leetcode.questions.tree;

import java.util.*;

public class KillProcess {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        int n = pid.size();
        // ppid <-> pids
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int parentId = ppid.get(i);

            map.getOrDefault(parentId, new HashSet<>()).add(pid.get(i));

            if (!map.containsKey(parentId)) {
                Set<Integer> set = new HashSet<>();
                set.add(pid.get(i));
                map.put(parentId, set);
            } else {
                map.get(parentId).add(pid.get(i));
            }
        }

        List<Integer> killedIds = new ArrayList<>();
        killedIds.add(kill);
        Queue<Integer> killQ = new LinkedList<>();

        if (map.containsKey(kill)) {
            killQ.addAll(map.get(kill));
        }

        while (!killQ.isEmpty()) {
            int size = killQ.size();

            for (int i = 0; i < size; i++) {
                Integer top = killQ.poll();
                killedIds.add(top);
                if (map.containsKey(top)) killQ.addAll(map.get(top));
            }
        }

        return killedIds;
    }
}
