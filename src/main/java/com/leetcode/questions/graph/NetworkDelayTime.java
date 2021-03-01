package com.leetcode.questions.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NetworkDelayTime {

    private int max = 0;

    public int networkDelayTime(int[][] times, int N, int K) {
        /*
        - construct an adjacency list to represent the network where:
            - the index of the list is the node number
            - the list at adjList[i] represents the neighbouring nodes of node i
        */

        ArrayList[] graph = new ArrayList[N];
        int[][] weights = new int[N][N];
        // set to keep track of visited nodes
        Set<Integer> visited = new HashSet<>();

        for (int[] time : times) {
            int u = time[0] - 1, v = time[1] - 1;
            if (graph[u] == null) {
                graph[u] = new ArrayList<>();
            }
            graph[u].add(v);
            weights[u][v] = time[2];
        }

        dfs(graph, weights, visited, K - 1, 0);

        return visited.size() == N ? max : -1;
    }

    private void dfs(List<Integer>[] graph, int[][] weights, Set<Integer> visited, int u, int time) {
        List<Integer> nodes = graph[u];
        visited.add(u);

        if (nodes == null) {
            max = Math.max(max, time);
            return;
        }

        for (int v : nodes) {
            dfs(graph, weights, visited, v, time + weights[u][v]);
        }
    }
}
