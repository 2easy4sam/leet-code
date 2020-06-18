package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

/**
 * Given a Binary Search Tree (BST) with root node root, and a target
 * value V, split the tree into two subtrees where one subtree has
 * nodes that are all smaller or equal to the target value, while the
 * other subtree has all nodes that are greater than the target value.
 * It's not necessarily the case that the tree contains a node with
 * value V.
 * <p>
 * Additionally, most of the structure of the original tree should
 * remain.  Formally, for any child C with parent P in the original
 * tree, if they are both in the same subtree after the split, then
 * node C should still have the parent P.
 * <p>
 * You should output the root TreeNode of both subtrees after
 * splitting, in any order.
 */
public class SplitBST {
    public TreeNode[] splitBST(TreeNode root, int V) {
        // base case
        if (root == null) return new TreeNode[2];
        // 1. IF root.val <= V, go right
        // 2. IF root.val > V, go left
        // In case 1, we know the split point is on rhs of root,
        // root.left remains unchanged
        // In case 2, we know the split point is on lhs of root,
        // root.right remain unchanged
        // Whenever we move left or right, there's a chance that the
        // next root.val = V
        // suppose we go root.left, and root.left.val = V
        // we then need to assign the right node of root.left to
        // root.left, i.e. root.left = root.left.right
        // and vice verse (i.e. if the root.right.val = V)

        TreeNode[] splitted;
        if (root.val <= V) {
            // go right
            splitted = splitBST(root.right, V);
            root.right = splitted[0];
            splitted[0] = root;
        } else {
            // go left
            splitted = splitBST(root.left, V);
            root.left = splitted[1];
            // returning left as we've only change left
            splitted[1] = root;
        }

        return splitted;
    }
}
