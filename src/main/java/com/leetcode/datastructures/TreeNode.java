package com.leetcode.datastructures;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TreeNode)) return false;
        if (o == this) return true;
        return this.hashCode() == o.hashCode();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.val;
        if (left != null) {
            result = 31 * result + left.hashCode();
        }
        if (right != null) {
            result = 31 * result + right.hashCode();
        }
        return result;
    }
}
