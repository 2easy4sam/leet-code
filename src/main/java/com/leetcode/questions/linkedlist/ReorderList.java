package com.leetcode.questions.linkedlist;

import com.leetcode.datastructures.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null) return;
        // 1. use two pointers slow + fast
        // 2. slow pushes nodes to queue as goes
        // 3. once fast reaches the end, slow pushes nodes to stack
        // 4. q.pop() -> stack.pop() -> q.pop() ...
        ListNode slow = head;
        ListNode fast = head;

        Queue<ListNode> q = new LinkedList<>();
        Stack<ListNode> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            ListNode slowNext = slow.next;
            ListNode fastNext = fast.next;
            slow.next = null;
            q.offer(slow);
            slow = slowNext;
            fast = fastNext.next;
        }

        while (slow != null) {
            ListNode next = slow.next;
            slow.next = null;
            stack.push(slow);
            slow = next;
        }

        ListNode prev = null;

        while (!q.isEmpty() || !stack.isEmpty()) {
            if (!q.isEmpty()) {
                if (prev == null) prev = q.poll();
                else {
                    prev.next = q.poll();
                    prev = prev.next;
                }
            }
            if (!stack.isEmpty()) {
                prev.next = stack.pop();
                prev = prev.next;
            }
        }
    }
}
