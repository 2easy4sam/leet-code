package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a binary tree, return the preorder
 * traversal of its nodes' values
 */
public class PreorderTraversalBST {
    public void preorderTraversalIter(TreeNode root) {

        Deque<TreeNode> stack = new LinkedList<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node != null) {
                System.out.println(root.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
    }

    public void preorderTraversalRecur(TreeNode root) {
        if (root == null) return;
        preorderTraversalRecur(root.left);
        System.out.println(root.val);
        preorderTraversalRecur(root.right);
    }
}
