package com.leetcode.questions;

import java.util.*;

public class InorderTraversalBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> solve(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<Integer> results = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {

            // push all left nodes into stack
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            // now that we have reached the last left node in this iteration
            // pop out the last entry and see if it has a right node
            // which may have a left node
            node = stack.pop();
            results.add(node.val);
            node = node.right;
        }

        return results;
    }
}
