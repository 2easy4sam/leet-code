package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;

import java.util.Stack;

public class RecoverATreeFromPreorder {
    // since it's preorder, the order goes from n.left -> n -> n.right
    public TreeNode recoverFromPreorder(String S) {
        if (S == null || S.equals("")) return null;

        char[] arr = S.toCharArray();
        int i = 0, c;
        int len = arr.length;
        Stack<TreeNode> stack = new Stack<>();

        while (i < len) {
            int level = 0;

            // dashes, count level
            while (i < len && parseInt(arr[i]) < 0) {
                level++;
                i++;
            }

            while (stack.size() > level) {
                // make sure that there's always 1 node at a level
                stack.pop();
            }

            int num = 0, factor = 1;

            while (i < len && (c = parseInt(arr[i])) >= 0) {
                i++;
                num = c + num * factor;
                factor = 10;
            }

            if (num > 0) {
                TreeNode node = new TreeNode(num);

                if (!stack.isEmpty()) {
                    if (stack.peek().left == null) {
                        stack.peek().left = node;
                    } else {
                        stack.peek().right = node;
                    }
                }

                stack.push(node);
            }
        }

        while (stack.size() > 1) {
            stack.pop();
        }

        return stack.pop();
    }

    private int parseInt(char c) {
        return c - '0';
    }
}
