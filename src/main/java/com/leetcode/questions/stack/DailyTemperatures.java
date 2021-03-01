package com.leetcode.questions.stack;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        Stack<int[]> stack = new Stack<>();
        int n = T.length;
        int[] res = new int[n];
        stack.push(new int[]{0, T[0]});

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && T[i] > stack.peek()[1]) {
                int[] top = stack.pop();
                res[top[0]] = i - top[0];
            }
            stack.push(new int[]{i, T[i]});
        }

        return res;
    }
}
