package com.leetcode.questions.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class PhoneDirectory {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private int max;
    private Set<Integer> set;

    /**
     * Initialize your data structure here
     *
     * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
     */
    public PhoneDirectory(int maxNumbers) {
        set = new HashSet<>();
        max = maxNumbers - 1;
        head = new Node(0);
        Node curr = head;

        for (int i = 1; i < maxNumbers; i++) {
            curr.next = new Node(i);
            curr = curr.next;
        }
    }

    /**
     * Provide a number which is not assigned to anyone.
     *
     * @return - Return an available number. Return -1 if none is available.
     */
    public int get() {
        if (head == null) return -1;
        int num = head.data;
        head = head.next;
        set.add(num);
        return num;
    }

    /**
     * Check if a number is available or not.
     */
    public boolean check(int number) {
        if (head == null) return false;
        return !set.contains(number);
    }

    /**
     * Recycle or release a number.
     */
    public void release(int number) {
        if (number < 0 || number > max || !set.contains(number))
            return;
        // find the right place to insert it
        if (head == null) head = new Node(number);
        else {
            Node curr = head;
            Node prev = null;

            // release 1
            // release 0
            // prev IS null and 0 should be the new head
            while (curr != null && number > curr.data) {
                prev = curr;
                curr = curr.next;
            }

            if (prev == null) {
                head = new Node(number);
                head.next = curr;
            } else {
                prev.next = new Node(number);
            }
        }

        set.remove(number);
    }
}
