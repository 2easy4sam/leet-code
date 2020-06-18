package com.leetcode.questions.graph;

import java.util.Arrays;

/**
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges
 * (each edge is a pair of nodes), write a function to check whether
 * these edges make up a valid tree.
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        // the definition of a tree is that each node in
        // the graph should have at most 1 parent
        // the nodes at the two ends of an edge should not
        // form a cycle
        int[] sets = new int[n];
        Arrays.fill(sets, -1);

        for (int[] edge : edges) {
            int x = find(sets, edge[0]);
            int y = find(sets, edge[1]);
            // two ends of the edge have the same rep
            // meaning, after following the links
            // two ends meet at the same place
            if (x == y) return false;

            sets[x] = y;
        }

        return edges.length == n - 1;
    }

    private int find(int[] sets, int i) {
        // recursively find where the link ends
        // i.e. the representative of the set
        if (sets[i] == -1) return i;
        // path compression
        // find the rep of current rep
        sets[i] = find(sets, sets[i]);
        return find(sets, sets[i]);
    }
}
