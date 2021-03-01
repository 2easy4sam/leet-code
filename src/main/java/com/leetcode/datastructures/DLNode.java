package com.leetcode.datastructures;

public class DLNode {
    public int val;
    public DLNode parent;
    public DLNode left;
    public DLNode right;

    public DLNode(int val) {
        this.val = val;
    }

    public DLNode setLeft(int val) {
        left = new DLNode(val);
        left.parent = this;
        return left;
    }

    public DLNode setRight(int val) {
        right = new DLNode(val);
        right.parent = this;
        return right;
    }
}
