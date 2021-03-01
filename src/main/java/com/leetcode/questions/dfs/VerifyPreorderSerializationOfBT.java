package com.leetcode.questions.dfs;

import java.util.Stack;

public class VerifyPreorderSerializationOfBT {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        String[] arr = preorder.split(",");

        for (String val : arr) {
            while (val.equals("#") && !stack.isEmpty() && stack.peek().equals("#")) {
                stack.pop();
                if (stack.isEmpty()) return false;
                stack.pop();
            }
            stack.push(val);
        }

        return stack.size() == 1 && stack.peek().equals("#");
    }
}
