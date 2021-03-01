package com.leetcode.questions.linkedlist;

import com.leetcode.datastructures.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given the head of a linked list, we repeatedly remove consecutive
 * sequences of nodes that sum to 0 until there are no such sequences.
 * <p>
 * After doing so, return the head of the final linked list.  You may
 * return any such answer.
 */
public class RemoveZeroSumConsecutiveNodesFromLL {

    public ListNode removeZeroSumSublists(ListNode head) {
        // base case
        // single element with value=0 counts?
        if (head == null) return null;

        // 1. keep sumSoFar (reset when sum 0 is found)
        // 2. pairwise sum = 0
        boolean modified = true;

        while (modified) {
            modified = false;
            ListNode curr = head;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode prev = dummy;
            int sumSoFar = 0;
            int i = 0;

            while (curr != null) {
                sumSoFar += curr.val;
                ListNode next = curr.next;

                if (i > 0 && sumSoFar == 0) {
                    dummy.next = next;
                    head = dummy.next;
                    modified = true;
                }
                if (curr.val == 0) {
                    prev.next = next;
                    if (head.val == 0) head = prev.next;
                    modified = true;
                }
                if (next != null && (curr.val + next.val) == 0) {
                    prev.next = next.next;
                    modified = true;
                }

                prev = curr;
                curr = next;
                i++;
            }

            if (head != null)
                head.next = removeZeroSumSublists(head.next);
        }

        return head;
    }

    public ListNode removeZeroSumSublistsPrefixSum(ListNode head) {
        ListNode dummy = new ListNode(0), curr = dummy;
        dummy.next = head;
        int prefix = 0;
        Map<Integer, ListNode> m = new HashMap<>();

        while (curr != null) {
            // because 'dummy' has a value of 0
            // the node that immediately follows it
            // will always be inserted into the map
            // i.e. dummy.next->dummy.next.val
            // take [0,2,0] as an example
            // 2->[2,0] will be the first entry in the map
            // in the following iteration, 'prefix' remains 2
            // which
            prefix += curr.val;

            if (m.containsKey(prefix)) {
                curr = m.get(prefix).next;
                int p = prefix + curr.val;

                // get all the nodes between the last node at which
                // 'prefix' has the same value and the current node
                // in the example of [0,2,0]
                // [0,2,0,null] will become [0,2,null]
                while (p != prefix) {
                    m.remove(p);
                    curr = curr.next;
                    p += curr.val;
                }
                m.get(prefix).next = curr.next;
            } else {
                m.put(prefix, curr);
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}
