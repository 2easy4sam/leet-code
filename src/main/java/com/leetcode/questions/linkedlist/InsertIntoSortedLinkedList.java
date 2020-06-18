package com.leetcode.questions.linkedlist;

import com.leetcode.datastructures.Node;

public class InsertIntoSortedLinkedList {

    public Node insert(Node head, int insertVal) {
        Node insertedNode = new Node(insertVal);
        // base case
        if (head == null) {
            insertedNode.next = insertedNode;
            return insertedNode;
        }

        // find min and max in the list
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Node p1 = head, p2 = head;

        do {
            min = Math.min(min, p1.val);
            max = Math.max(max, p1.val);
            p1 = p1.next;
            p2 = p2.next.next;
        } while (p1 != p2);

        Node curr = head;

        if (insertVal <= min || insertVal >= max) {
            // find node where node.val == max AND node.next.val == min
            while (!(curr.val == max && curr.next.val == min))
                curr = curr.next;
        } else {
            // move pointer to min
            while (curr.val != min) curr = curr.next;
            // find the place
            while (!(insertVal >= curr.val && insertVal <= curr.next.val))
                curr = curr.next;
        }

        insertedNode.next = curr.next;
        curr.next = insertedNode;

        return head;
    }
}
