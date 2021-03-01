package com.leetcode.questions.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(graph, 0, new LinkedList<>(), res);

        return res;
    }

    private void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> res) {
        path.add(node);

        int[] neighbours = graph[node];
        if (neighbours.length == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int neighbour : neighbours) {
            dfs(graph, neighbour, path, res);
            if (path.size() > 0) path.remove(path.size() - 1);
        }
    }
}
