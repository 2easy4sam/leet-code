package com.leetcode.questions;

import java.util.Deque;
import java.util.LinkedList;

public class SearchBST {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val == val) return node;

            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return null;
    }
}
