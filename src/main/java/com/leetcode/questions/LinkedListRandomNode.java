package com.leetcode.questions;

import com.leetcode.datastructures.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinkedListRandomNode {
//    private List<Integer> linkedList;
//
//    public LinkedListRandomNode(ListNode head) {
//        linkedList = new ArrayList<>();
//
//        while (head != null) {
//            linkedList.add(head.val);
//            head = head.next;
//        }
//    }
//
//    public int getRandom() {
//        return linkedList.get(randomInt(0, linkedList.size() - 1));
//    }

    private final List<Integer> oddList;
    private final List<Integer> evenList;

    public LinkedListRandomNode(ListNode head) {
        oddList = new ArrayList<>();
        evenList = new ArrayList<>();

        ListNode odd = head;
        ListNode even = head.next;

        while (even != null && even.next != null) {
            oddList.add(odd.val);
            evenList.add(even.val);

            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
    }

    public int getRandom() {
        int randIdx = randomInt(0, 1);

        return randIdx == 0
                ? oddList.get(randomInt(0, oddList.size() - 1))
                : evenList.get(randomInt(0, evenList.size() - 1));
    }

    private int randomInt(int lowerBound, int upperBound) {
        Random random = new Random(System.currentTimeMillis());

        if (lowerBound > upperBound) {
            int temp = lowerBound;
            lowerBound = upperBound;
            upperBound = temp;
        }

        int diff = upperBound - lowerBound;

        return (int) (diff * random.nextDouble()) + lowerBound;
    }
}
