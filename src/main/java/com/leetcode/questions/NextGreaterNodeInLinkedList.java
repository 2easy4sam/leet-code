package com.leetcode.questions;

import com.leetcode.datastructures.ListNode;

import java.util.Stack;

public class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        int size = 0;

        while (head != null) {
            stack.push(head);
            head = head.next;
            size++;
        }

        int[] answer = new int[size];
        int[] vals = new int[size];
        int idx = size - 1;

        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            vals[idx] = node.val;

            for (int i = idx; i < size; i++) {
                if (vals[i] > vals[idx]) {
                    answer[idx] = vals[i];
                    break;
                }
            }

            idx--;
        }

        return answer;
    }

}
