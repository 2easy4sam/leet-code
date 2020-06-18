package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;

import java.util.Stack;

public class ConstructBinaryTreeFromString {
    public TreeNode str2tree(String s) {
        if (s == null || s.isEmpty()) return null;

        Stack<TreeNode> stack = new Stack<>();
        char[] charArr = s.toCharArray();

        StringBuilder sb = new StringBuilder();

        for (char c : charArr) {
            if (c == '-' || Character.isDigit(c)) {
                sb.append(c);
            } else if (!sb.toString().isEmpty()) {
                TreeNode current = new TreeNode(Integer.parseInt(sb.toString()));
                sb.setLength(0);

                if (!stack.isEmpty()) {
                    if (stack.peek().left == null) {
                        stack.peek().left = current;
                    } else {
                        stack.peek().right = current;
                    }
                }

                stack.push(current);
            }

            if (c == ')') {
                stack.pop();
            }
        }

        return stack.pop();
    }
}
