package com.leetcode.questions.graph;

import java.util.*;

public class MinTimeToCollectAllApples1443 {
    private List<List<Integer>> trails;

    /*
    - loop through edges, build a map
    - dfs
        - record every trail from 0 to apples[i]
        - the duration of a trail (round-trip) == trail.size() * 2
    */
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        trails = new ArrayList<>();
        Map<Integer, Set<Integer>> tree = new HashMap<>();

        for (int[] edge : edges) {
            connect(tree, edge[0], edge[1]);
            connect(tree, edge[1], edge[0]);
        }

        dfs(tree, new ArrayList<>(), hasApple, new boolean[n], 0);

        if (trails.size() == 0) return 0;

        int time = (trails.get(0).size() - 1) * 2;

        for (int i = 0; i < trails.size() - 1; i++) {
            List<Integer> t1 = trails.get(i);
            List<Integer> t2 = trails.get(i + 1);

            int j = 0;

            while (j < Math.min(t1.size(), t2.size())) {
                if (t1.get(j).equals(t2.get(j))) j++;
                else break;
            }

            // at this point, jth elements are different
            time += (t2.size() - j) * 2;
        }

        return time;
    }

    private void dfs(Map<Integer, Set<Integer>> tree, List<Integer> trail, List<Boolean> hasApple, boolean[] visited, int from) {
        if (visited[from]) return;
        visited[from] = true;
        List<Integer> copy = new ArrayList<>(trail);
        copy.add(from);

        if (hasApple.get(from)) trails.add(copy);

        for (int to : tree.getOrDefault(from, new HashSet<>())) {
            dfs(tree, copy, hasApple, visited, to);
        }
    }

    private void connect(Map<Integer, Set<Integer>> tree, int from, int to) {
        tree.putIfAbsent(from, new HashSet<>());
        tree.get(from).add(to);
    }
}
