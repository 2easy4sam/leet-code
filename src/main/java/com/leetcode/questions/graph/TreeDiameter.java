package com.leetcode.questions.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an undirected tree, return its diameter: the number of edges
 * in a longest path in that tree.
 * <p>
 * The tree is given as an array of edges where edges[i] = [u, v] is
 * a bidirectional edge between nodes u and v.  Each node has labels
 * in the set {0, 1, ..., edges.length}.
 */
public class TreeDiameter {
    private int diameter = 0;

    public int treeDiameter(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new LinkedList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        dfs(0, -1, graph);

        return diameter;
    }

    private int dfs(int root, int parent, List<Integer>[] graph) {
        // the idea is to find the top 2 depths
        // starting from each node
        // compare the sum to the current max depth
        // recursively until the graph is exhausted
        int maxDepth1 = 0, maxDepth2 = 0;

        for (int child : graph[root]) {
            // the sure that we only traverse in one direction
            if (child == parent) continue;
            int childDepth = dfs(child, root, graph);

            if (childDepth > maxDepth1) {
                maxDepth2 = maxDepth1;
                maxDepth1 = childDepth;
            } else if (childDepth > maxDepth2) {
                maxDepth2 = childDepth;
            }
        }

        int longestDiameter = maxDepth1 + maxDepth2 + 1; // +1 because
        diameter = Math.max(diameter, longestDiameter - 1);
        return maxDepth1 + 1;
    }
}
