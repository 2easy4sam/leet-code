package com.leetcode.questions.dfs;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class NumberOfNodesInTheSubTreesWIthTheSameLabel1519 {
    /*
    - from the edges, construct a tree (or hashmap)
    */
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, Set<Integer>> tree = new LinkedHashMap<>();

        for (int[] edge : edges) {
            tree.putIfAbsent(edge[0], new HashSet<>());
            tree.get(edge[0]).add(edge[1]);
            tree.putIfAbsent(edge[1], new HashSet<>());
            tree.get(edge[1]).add(edge[0]);
        }

        int[] ans = new int[n];

        dfs(tree, 0, labels.toCharArray(), new boolean[n], ans);

        return ans;
    }

    private int[] dfs(Map<Integer, Set<Integer>> tree, int curr, char[] labels, boolean[] visited, int[] ans) {
        if (visited[curr]) return new int[26];
        visited[curr] = true;
        // 26 english letters
        int[] cnts = new int[26];

        for (int next : tree.getOrDefault(curr, new HashSet<>())) {
            int[] sub_cnts = dfs(tree, next, labels, visited, ans);

            for (int i = 0; i < 26; i++) {
                cnts[i] += sub_cnts[i];
            }
        }

        cnts[labels[curr] - 'a']++;
        ans[curr] += cnts[labels[curr] - 'a'];
        return cnts;
    }
}
