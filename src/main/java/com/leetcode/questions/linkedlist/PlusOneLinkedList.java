package com.leetcode.questions.linkedlist;

import com.leetcode.datastructures.ListNode;

public class PlusOneLinkedList {

    public ListNode plusOne(ListNode head) {
        StringBuilder sb = new StringBuilder();

        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }

        int len = sb.length();
        int lastIdx = len - 1;

        for (int i = lastIdx; i >= 0; i--) {
            char curr = sb.charAt(i);

            if ((int) curr < 57) {
                sb.setCharAt(i, ++curr);
                break;
            } else {
                sb.setCharAt(i, '0');
            }
        }

        if (sb.charAt(0) == '0') sb.insert(0, '1');

        ListNode newHead = new ListNode(sb.charAt(0) - 48);
        ListNode copy = newHead;

        for (int i = 1; i < sb.length(); i++) {
            copy.next = new ListNode(sb.charAt(i) - 48);
            copy = copy.next;
        }

        return newHead;
    }
}
