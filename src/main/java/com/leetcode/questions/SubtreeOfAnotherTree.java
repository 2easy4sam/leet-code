package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;

import java.util.Stack;

public class SubtreeOfAnotherTree {
    public boolean isSubtree2(TreeNode s, TreeNode t) {
        // if both are null, they are identical
        if (s == null) return t == null;
        // at this point we know that s is not null
        // t can't be a subtree of s if it's null
        if (t == null) return false;

        // traverse s
        Stack<TreeNode> stack = new Stack<>();
        stack.push(s);

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();

            if (top != null) {
                if (areIdentical(top, t)) {
                    return true;
                }
                stack.push(top.left);
                stack.push(top.right);
            }
        }

        return false;
    }

    private boolean areIdentical(TreeNode n1, TreeNode n2) {
        if (n1 == null) return n2 == null;
        if (n2 == null) return false;
        if (n1.val != n2.val) return false;
        return areIdentical(n1.left, n2.left) && areIdentical(n1.right, n2.right);
    }

    /**************************************************/

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.val != t.val) return false;

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
