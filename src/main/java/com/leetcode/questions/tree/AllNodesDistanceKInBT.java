package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBT {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                root = q.poll();

                if (root.left != null) {
                    addConnection(graph, root.val, root.left.val);
                    addConnection(graph, root.left.val, root.val);
                    q.offer(root.left);
                }
                if (root.right != null) {
                    addConnection(graph, root.val, root.right.val);
                    addConnection(graph, root.right.val, root.val);
                    q.offer(root.right);
                }
            }
        }

        List<Integer> res = new ArrayList<>();

        // calculate distance from target to all nodes
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(target.val);

        int distance = 0;
        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty() && distance < K) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                visited.add(node);
                if (distance == K) res.add(node);

                for (int n : graph.get(node)) {
                    if (!visited.contains(n)) queue.offer(n);
                }
            }

            distance++;
        }

        return res;
    }

    private void addConnection(Map<Integer, Set<Integer>> graph, int a, int b) {
        if (graph.containsKey(a)) {
            graph.get(a).add(b);
        } else {
            graph.put(a, new HashSet<>(Arrays.asList(b)));
        }
    }
}
