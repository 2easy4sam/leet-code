package com.leetcode.datastructures;

/**
 * A class that represents a node in a linked list
 */
public class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }

    public void append(int data) {
        Node end = new Node(data);

        Node n = this;

        while (n.next != null) {
            n = n.next;
        }

        n.next = end;
    }
}
