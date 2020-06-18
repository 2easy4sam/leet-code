package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of a BST.
 * <p>
 * Calling next() will return the next smallest number in the BST.
 */
public class BSTIterator {

    private TreeNode visited;
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        visited = root;
        stack = new Stack<>();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        while (visited != null) {
            stack.push(visited);
            visited = visited.left;
        }

        TreeNode top = stack.pop();
        visited = top.right;

        return top.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return visited != null || !stack.isEmpty();
    }
}
