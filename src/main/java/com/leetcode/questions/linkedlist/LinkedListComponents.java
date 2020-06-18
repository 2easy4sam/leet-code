package com.leetcode.questions.linkedlist;

import com.leetcode.datastructures.ListNode;

/**
 * We are given head, the head node of a linked list containing unique
 * integer values.
 * We are also given the list G, a subset of the values in the linked
 * list.
 * <p>
 * Return the number of connected components in G, where two values
 * are connected if they appear consecutively in the linked list.
 */
public class LinkedListComponents {
    private static final int N = 10000;

    public int numComponents(ListNode head, int[] G) {
        // base case
        if (head == null || G == null) return 0;

        int[] cnt = new int[N];

        ListNode copy = head;

        while (copy != null) {
            cnt[copy.val]++;
            copy = copy.next;
        }

        for (int num : G) {
            cnt[num]++;
        }

        int n = 0;
        int twos = 0;

        while (head != null) {
            if (cnt[head.val] == 2) twos++;
            else if (twos > 0) {
                n++;
                twos = 0;
            }
            head = head.next;
        }

        if (twos > 0) n++;

        return n;
    }
}
