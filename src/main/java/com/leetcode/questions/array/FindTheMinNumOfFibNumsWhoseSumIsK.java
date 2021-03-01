package com.leetcode.questions.array;

import java.util.Arrays;
import java.util.Stack;

public class FindTheMinNumOfFibNumsWhoseSumIsK {

    public int findMinFibonacciNumbers(int k) {
        /*
        1. generate a fibonacci sequence that stops at n, where n is the largest number that
        is smaller than k
        2. pick the largest number l from the sequence, work out the difference between it and k
        IF diff < 0, choose the next one in sequence
        ELSE k = k - l
        3. repeaat step 2 until k == 0
        */

        if (k <= 3) return 1;
        Stack<Integer> stack = new Stack<>();
        stack.addAll(Arrays.asList(1, 1, 2, 3));

        // generate sequence until the generated number is > k
        while (!stack.isEmpty() && stack.peek() < k) {
            int top = stack.pop();
            int next = top + stack.peek();

            if (next >= k) {
                if (next == k) return 1;
                stack.push(top);
                break;
            } else {
                stack.push(top);
                stack.push(next);
            }
        }

        int len = 0;

        while (!stack.isEmpty() && k != 0) {
            int top = stack.pop();
            if (top < k) {
                k -= top;
                len++;
            }
        }

        return len;
    }
}
