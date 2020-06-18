package com.leetcode.questions.graph;

import java.util.*;

/**
 * In this problem, a tree is an undirected graph that is connected
 * and has no cycles.
 * <p>
 * The given input is a graph that started as a tree with N nodes
 * (with distinct values 1, 2, ..., N), with one additional edge
 * added. The added edge has two different vertices chosen from 1 to
 * N, and was not an edge that already existed.
 * <p>
 * The resulting graph is given as a 2D-array of edges. Each element
 * of edges is a pair [u, v] with u < v, that represents an undirected
 * edge connecting nodes u and v.
 * <p>
 * Return an edge that can be removed so that the resulting graph is a
 * tree of N nodes. If there are multiple answers, return the answer
 * that occurs last in the given 2D-array. The answer edge [u, v]
 * should be in the same format, with u < v.
 */
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        // 1. loop through edges and build a graph
        // 2. loop through edges again and iteratively
        // remove edges and see if the graph remain valid
        // yes -> push it to the stack
        // no -> continue
        Stack<int[]> stack = new Stack<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        // build graph
        for (int[] edge : edges) {
            addEdge(edge[0], edge[1], graph);
            addEdge(edge[1], edge[0], graph);
        }

        for (int[] edge : edges) {
            if (countNodes(edge, graph) == graph.size())
                stack.push(edge);
        }

        return stack.pop();
    }

    private int countNodes(int[] edge, Map<Integer, Set<Integer>> graph) {
        Set<Integer> visitedNodes = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(edge[0]);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int top = q.poll();
                visitedNodes.add(top);
                Set<Integer> neighbours = graph.get(top);

                for (int neighbour : neighbours) {
                    if (!visitedNodes.contains(neighbour)
                            && !(top == edge[0] && neighbour == edge[1]
                            || top == edge[1] && neighbour == edge[0])
                    ) {
                        q.offer(neighbour);
                        visitedNodes.add(neighbour);
                    }
                }
            }
        }

        return visitedNodes.size();
    }

    private void addEdge(int u, int v, Map<Integer, Set<Integer>> graph) {
        if (graph.containsKey(u)) {
            graph.get(u).add(v);
        } else {
            Set<Integer> neighbours = new HashSet<>();
            neighbours.add(v);
            graph.put(u, neighbours);
        }
    }
}
