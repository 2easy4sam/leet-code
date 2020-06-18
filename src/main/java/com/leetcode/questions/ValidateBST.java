package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        // all left descendents <= n < all right descendents
        // using in-order traversal, so that we'd always pop out the left descendents first
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.offer(root);
                root = root.left;
            }

            // now that we have reached the end of the left branch
            // pop out the last inserted left descendent, and insert its right descendent
            root = stack.poll();
            if (prev != null && prev.val >= root.val) return false;
            prev = root;
            root = root.right;
        }

        return true;
    }

    public boolean validateBSTResursive(TreeNode root) {
        return validateBST(root, null, null);
    }

    private boolean validateBST(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;

        if (min != null && node.val < min) return false;
        if (max != null && node.val > max) return false;

        return validateBST(node.left, min, node.val) && validateBST(node.right, node.val, max);
    }
}
