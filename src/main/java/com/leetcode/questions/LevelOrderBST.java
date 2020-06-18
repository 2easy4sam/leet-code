package com.leetcode.questions;

import java.util.*;

public class LevelOrderBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> solve(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> level = new ArrayList<>();

        if (root == null) return results;

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.remove();

            if (node != null) {
                level.add(node.val);
                if (node.left != null)
                    queue2.add(node.left);
                if (node.right != null)
                    queue2.add(node.right);
            }

            if (queue.isEmpty()) {
                results.add(level);
                level = new ArrayList<>();
                queue.addAll(queue2);
                queue2 = new LinkedList<>();
            }
        }

        return results;
    }
}
