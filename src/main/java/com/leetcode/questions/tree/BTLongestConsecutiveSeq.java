package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

/**
 * Given a binary tree, find the length of the longest consecutive
 * sequence path.
 * <p>
 * The path refers to any sequence of nodes from some starting node
 * to any node in the tree along the parent-child connections. The
 * longest consecutive path need to be from parent to child (cannot be
 * the reverse).
 */
public class BTLongestConsecutiveSeq {
    private int max = 0;

    public int longestConsecutive(TreeNode root) {
        if (root != null) dfs(root, root.val - 1, 0);
        return max;
    }

    private void dfs(TreeNode root, int parent, int depth) {
        if (root == null) {
            max = Math.max(max, depth);
            return;
        }

        depth = root.val == parent + 1 ? depth + 1 : 1;
        max = Math.max(max, depth);
        dfs(root.left, root.val, depth);
        dfs(root.right, root.val, depth);
    }
}
