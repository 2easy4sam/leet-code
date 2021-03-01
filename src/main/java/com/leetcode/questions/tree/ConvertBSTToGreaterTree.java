package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

public class ConvertBSTToGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        dfs(root, false, 0);
        return root;
    }

    private int dfs(TreeNode node, boolean isLeft, int val) {
        if (node == null) return 0;
        if (val > node.val) node.val += val;
        int r = dfs(node.right, false, isLeft ? node.val - val : val);
        node.val += r;
        dfs(node.left, true, isLeft && node.right != null ? node.val - val : node.val);

        return node.val;
    }
}
