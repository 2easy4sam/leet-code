package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;

public class MinimumDistanceBetweenBSTNodes {
    private Integer res = Integer.MAX_VALUE, pre;

    public int minDiffInBST(TreeNode root) {
        if (root.left != null) minDiffInBST(root.left);
        if (pre != null) res = Math.min(res, root.val - pre);
        pre = root.val;
        if (root.right != null) minDiffInBST(root.right);
        return res;
    }
}
