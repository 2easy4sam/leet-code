package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

/**
 * Given a binary tree, you need to find the length of Longest
 * Consecutive Path in Binary Tree.
 * <p>
 * Especially, this path can be either increasing or decreasing.
 * For example, [1,2,3,4] and [4,3,2,1] are both considered valid,
 * but the path [1,2,4,3] is not valid. On the other hand, the path
 * can be in the child-Parent-child order, where not necessarily be
 * parent-child order.
 */
public class BTLongestConsecutiveSeqII {
    private int max = 0;

    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max;
    }

    /**
     * use post-order dfs to recursively check the current node's
     * relationship to its children
     */
    private int[] dfs(TreeNode root) {
        if (root == null) return null;
        // a node can be in either ascending or descending order
        // in relation to its left/right child (or neither)
        // but NEVER both at the same time
        int[] l = dfs(root.left), r = dfs(root.right);

        int[] curr = new int[]{1, 1, root.val};

        if (l != null) {
            if (l[2] + 1 == root.val) {
                curr[0] = Math.max(curr[0], l[0] + 1);
            } else if (l[2] - 1 == root.val) {
                curr[1] = Math.max(curr[1], l[1] + 1);
            }
        }

        if (r != null) {
            if (r[2] + 1 == root.val) {
                curr[0] = Math.max(curr[0], r[0] + 1);
            } else if (r[2] - 1 == root.val) {
                curr[1] = Math.max(curr[1], r[1] + 1);
            }
        }

        max = Math.max(max, curr[0] + curr[1] - 1);

        return curr;
    }
}
