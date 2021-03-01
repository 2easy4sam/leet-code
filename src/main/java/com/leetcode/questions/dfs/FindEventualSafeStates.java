package com.leetcode.questions.dfs;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();

        int n = graph.length;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            if (dfs(graph, visited, i)) res.add(i);
            visited[i] = false;
        }

        return res;
    }

    private boolean dfs(int[][] graph, boolean[] visited, int curr) {
        if (graph[curr].length == 0) {
            // safe state reached
            return true;
        }

        for (int next : graph[curr]) {
            // cycle detected
            if (visited[next]) return false;

            visited[next] = true;
            if (!dfs(graph, visited, next)) {
                visited[next] = false;
                return false;
            }
            visited[next] = false;
        }

        return true;
    }

//    public List<Integer> eventualSafeNodes(int[][] graph) {
//        Set<Integer> unsafeStates = new HashSet<>();
//        List<Integer> res = new ArrayList<>();
//
//        int n = graph.length;
//        boolean[] visited = new boolean[n];
//
//        for (int i = 0; i < n; i++) {
//            if (unsafeStates.contains(i)) continue;
//
//            visited[i] = true;
//
//            if (dfs(graph, visited, unsafeStates, i)) {
//                res.add(i);
//            } else {
//                unsafeStates.add(i);
//            }
//
//            visited[i] = false;
//        }
//
//        return res;
//    }
//
//    private boolean dfs(int[][] graph, boolean[] visited, Set<Integer> unsafeStates, int curr) {
//        if (unsafeStates.contains(curr)) return false;
//
//        if (graph[curr].length == 0) {
//            // safe state reached
//            return true;
//        }
//
//        for (int next : graph[curr]) {
//            // cycle detected
//            if (visited[next]) {
//                unsafeStates.add(curr);
//                return false;
//            }
//
//            visited[next] = true;
//
//            if (unsafeStates.contains(next) || !dfs(graph, visited, unsafeStates, next)) {
//                visited[next] = false;
//                return false;
//            }
//
//            visited[next] = false;
//        }
//
//        return true;
//    }
}
