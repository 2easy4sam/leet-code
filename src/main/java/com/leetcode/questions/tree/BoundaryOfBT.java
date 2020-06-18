package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a binary tree, return the values of its boundary in
 * anti-clockwise direction starting from root. Boundary includes
 * left boundary, leaves, and right boundary in order without
 * duplicate nodes. (The values of the nodes may still be duplicates)
 * <p>
 * Left boundary is defined as the path from root to the left-most
 * node. Right boundary is defined as the path from root to the
 * right-most node. If the root doesn't have left subtree or right
 * subtree, then the root itself is left boundary or right boundary.
 * Note this definition only applies to the input binary tree, and
 * not applies to any subtrees.
 * <p>
 * The left-most node is defined as a leaf node you could reach when
 * you always firstly travel to the left subtree if exists. If not,
 * travel to the right subtree. Repeat until you reach a leaf node.
 * <p>
 * The right-most node is also defined by the same way with left and
 * right exchanged.
 */
public class BoundaryOfBT {
    private List<Integer> res;

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) return Collections.emptyList();
        // use in-order and reverse in-order

        res = new ArrayList<>();
        if (root.left != null || root.right != null)
            res.add(root.val);

        dfsL(root.left);
        dfs(root);
        dfsR(root.right);
        return res;
    }

    private void dfsL(TreeNode root) {
        if (root == null
                || (root.left == null && root.right == null)) return;
        res.add(root.val);
        if (root.left != null) dfsL(root.left);
        else dfsL(root.right);
    }

    private void dfsR(TreeNode root) {
        if (root == null
                || (root.left == null && root.right == null)) return;
        if (root.right != null) dfsR(root.right);
        else dfsR(root.left);
        res.add(root.val);
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null)
            res.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
