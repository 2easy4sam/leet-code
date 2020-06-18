package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

/**
 * Given a complete binary tree, count the number of nodes.
 * <p>
 * Note:
 * <p>
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last,
 * is completely filled, and all nodes in the last level are as far
 * left as possible. It can have between 1 and 2h nodes inclusive at
 * the last level h.
 */
public class CountCompleteTreeNodes {
    private int maxDepth = 0;
    private int nNodesBottom = 0;

    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        // 1. brute force (count every node recursively)
        // 2. count the level and the nodes at the bottom level
        dfs(root, 0);
        return Math.max(((int) Math.pow(2, maxDepth - 1) << 1) - 1 +
                nNodesBottom, 1);
    }

    private void dfs(TreeNode root, int depth) {
        maxDepth = Math.max(maxDepth, depth);

        if (depth == maxDepth && root.left == null && root.right == null) {
            // leaf node
            nNodesBottom++;
        }

        if (root.left != null) dfs(root.left, depth + 1);
        if (root.right != null) dfs(root.right, depth + 1);
    }
}
