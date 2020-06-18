package com.leetcode.questions.linkedlist;

import com.leetcode.datastructures.ListNode;

public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        // cases:
        // 1.   IF total number of nodes <= k
        //      THEN each node takes a place in "parts"
        // 2.   IF total number of nodes > k
        //      THEN calculate n / k = size
        //      AND n % k = r
        //      AND for the first r "parts", size += 1
        // 3.   IF root == null
        //      THEN return "parts" with nulls
        if (root == null) return new ListNode[]{};
        if (k == 0) return new ListNode[]{root};

        ListNode[] parts = new ListNode[k];

        int n = 0;

        ListNode head = root;

        while (head != null) {
            n++;
            head = head.next;
        }

        int size = 1;
        int r = 0;

        if (n > k) {
            size = n / k;
            r = n % k;

            if (r > 0) {
                size++;
            }
        }

        int i = 0;

        head = root;

        int cnt = 0;
        for (int j = 0; j < n; j++) {
            ++cnt;
            ListNode next = root.next;
            // work out cut-off points
            if (cnt == size) {
                root.next = null;
                parts[i++] = head;
                head = next;

                if (r > 0 && --r == 0) {
                    size--;
                }

                cnt = 0;
            }
            root = next;
        }

        return parts;
    }
}
