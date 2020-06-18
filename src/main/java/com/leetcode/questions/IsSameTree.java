package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;

public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) return q == null;
        if (q == null) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
