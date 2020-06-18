package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 */
public class FlattenBTToLinkedList {
    public void flatten2(TreeNode root) {
        // if a node has left and right nodes
        // its right node becomes the right node
        // of its left node, and its left node
        // subsequently become the new right node
        helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        TreeNode right = helper(root.right);
        if (root.left != null) {
            TreeNode farLeft = helper(root.left);
            TreeNode farLeftRight = farLeft.right;

            if (farLeftRight != null) {
                while (farLeftRight.right != null) {
                    farLeftRight = farLeftRight.right;
                }

                farLeftRight.right = right;
            } else {
                root.left.right = right;
            }
            root.right = farLeft;
            root.left = null;
        }

        return root;
    }

    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;

        flatten(left);
        flatten(right);

        root.right = left;
        TreeNode cur = root;
        while (cur.right != null) cur = cur.right;
        cur.right = right;
    }
}
