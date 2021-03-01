package com.leetcode.questions.design;

import java.util.Stack;

public class MaxStack {

    private Stack<Integer> stack;
    private Stack<Integer> maxStack;

    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        helper(x);
    }

    private void helper(int x) {
        int max = maxStack.isEmpty() ? Integer.MIN_VALUE : maxStack.peek();

        if (x > max) {
            max = x;
        }

        stack.push(x);
        maxStack.push(max);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = maxStack.peek();
        Stack<Integer> temp = new Stack<>();

        while (stack.peek() != max) {
            maxStack.pop();
            temp.push(stack.pop());
        }

        maxStack.pop();
        stack.pop();

        while (!temp.isEmpty()) {
            helper(temp.pop());
        }

        return max;
    }
}
