package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

import java.util.Stack;

public class TreeToDoublyList {

    public TreeNode treeToDoublyList(TreeNode root) {
        // base case
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode top = stack.pop();
            top.left = prev;
            if (prev != null) prev.right = top;
            TreeNode right = top.right;

            if (top.right == null && !stack.isEmpty()) {
                top.right = stack.peek();
            }
            prev = top;
            root = right;
        }

        // find the left most
        TreeNode head = prev;

        while (head.left != null) {
            head = head.left;
        }

        head.left = prev;
        prev.right = head;

        return head;
    }
}
