package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two
 * given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common
 * ancestor is defined between two nodes p and q as the lowest node in
 * T that has both p and q as descendants (where we allow a node to be
 * a descendant of itself).”
 */
public class LowestCommonAncestorOfBT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if root is either p or q, then we know that root at the beginning of this
        // recursion stack is its ancestor
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // we are able to find p and q in left and right branches
        // of the current root, therefore it is their LCA
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }
}
