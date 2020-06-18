package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

import java.util.*;

public class SmallestSubtreeWithAllTheDeepestNodes {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        // in other words, find the parent of the deepest node
        if (root == null) return null;
        // when we seiralize a tree (as an array), we know that
        // the deepest nodes are the last ones

        Queue<TreeNode> q = new LinkedList<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        List<List<TreeNode>> levels = new ArrayList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<TreeNode> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                root = q.poll();

                if (root != null) {
                    level.add(root);

                    if (root.left != null) {
                        map.put(root.left.val, root);
                        q.offer(root.left);
                    }

                    if (root.right != null) {
                        map.put(root.right.val, root);
                        q.offer(root.right);
                    }
                }
            }

            if (level.size() != 0) {
                levels.add(level);
            }
        }

        // find the common ancestor of all the nodes at the bottom level
        int idx = levels.size() - 1 < 0 ? 0 : levels.size() - 1;
        if (idx == 0) return levels.get(0).get(0);

        for (TreeNode node : levels.get(idx)) {
            q.offer(node);
        }

        while (q.size() != 1) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                root = q.poll();

                TreeNode parent = map.get(root.val);

                if (!q.contains(parent)) {
                    q.offer(parent);
                }
            }
        }

        return q.poll();
    }

    public TreeNode subtreeWithAllDeepestR(TreeNode root) {
        if (root == null) return null;
        // first, find the depth of each node (relative to the deepest nodes)
        Map<TreeNode, Integer> map = new HashMap<>();
        depth(root, map);
        return dfs(root, map);
    }

    private int depth(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int max = Math.max(depth(root.left, map), depth(root.right, map)) + 1;
        map.put(root, max);
        return max;
    }

    private TreeNode dfs(TreeNode root, Map<TreeNode, Integer> map) {
        int l = depth(root.left, map);
        int r = depth(root.right, map);
        if (l == r) return root;
        else if (l > r) return dfs(root.left, map);
        return dfs(root.right, map);
    }
}
