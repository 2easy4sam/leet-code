package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;
        if (root.left != null && root.left.val > root.val) return false;
        if (root.right != null && root.right.val < root.val) return false;
        if (root.left == null && root.right == null) return true;
        return isValidBST(root.left) && isValidBST(root.right);
    }
}
