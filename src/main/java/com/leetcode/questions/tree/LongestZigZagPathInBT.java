package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

/**
 * Given a binary tree root, a ZigZag path for a binary tree is
 * defined as follow:
 * <p>
 * Choose any node in the binary tree and a direction (right
 * or left).
 * If the current direction is right then move to the right child
 * of the current node otherwise move to the left child.
 * Change the direction from right to left or right to left.
 * Repeat the second and third step until you can't move in the
 * tree.
 * Zigzag length is defined as the number of nodes visited - 1.
 * (A single node has a length of 0).
 * <p>
 * Return the longest ZigZag path contained in that tree.
 */
public class LongestZigZagPathInBT {

    private int max = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root.left, true, 1);
        dfs(root.right, false, 1);
        return max;
    }

    private void dfs(TreeNode root, boolean isLeft, int depth) {
        if (root == null) return;
        max = Math.max(max, depth);
        if (isLeft) {
            dfs(root.right, false, depth + 1);
            dfs(root.left, true, 1);
        } else {
            dfs(root.left, true, depth + 1);
            dfs(root.right, false, 1);
        }
    }
}
