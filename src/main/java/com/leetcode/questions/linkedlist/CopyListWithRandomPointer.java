package com.leetcode.questions.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /*
    1. use a hashmap to keep track of each node and its index

    Node <-> index of random node

    using Node as key as there may be duplicates
    2. 2nd pass, create list
    */
    public Node copyRandomList(Node head) {
        // base case
        if (head == null) return null;
        Map<Node, Integer> map = new HashMap<>();

        Node curr = head;
        int i = 0;

        while (curr != null) {
            map.put(curr, i);
            curr = curr.next;
            i++;
        }

        curr = head;
        Node newHead = new Node(head.val);
        newHead.random = head.random == null ? null : new Node(map.get(head.random));
        Node curr2 = newHead;
        curr = curr.next;

        while (curr != null) {
            Node random = curr.random == null ? null : new Node(map.get(curr.random));
            curr2.next = new Node(curr.val);
            curr2.next.random = random;
            curr2 = curr2.next;
            curr = curr.next;
        }

        return newHead;
    }
}
