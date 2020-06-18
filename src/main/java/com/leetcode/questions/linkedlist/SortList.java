package com.leetcode.questions.linkedlist;

import com.leetcode.datastructures.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortList {
    public ListNode sortList(ListNode head) {
        // bear in mind that val can be negative
        if (head == null) return null;

        List<ListNode> list = new ArrayList<>();

        int max = head.val;

        while (head != null) {
            max = Math.max(max, head.val);

            ListNode next = head.next;
            head.next = null;
            list.add(head);
            head = next;
        }

        return bucketSort(list, max);
    }

    private ListNode bucketSort(List<ListNode> list, int max) {
        // 1. find max
        // 2. init buckets
        // 3. distribute elements to buckets
        // 4. sort each bucket
        // 5. merge buckets

        int nBuckets = list.size();
        List<List<ListNode>> buckets = new ArrayList<>();

        for (int i = 0; i < nBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        for (ListNode node : list) {
            int idx = hash(node, max, nBuckets);
            buckets.get(idx).add(node);
        }

        List<ListNode> sortedList = new ArrayList<>();

        for (List<ListNode> bucket : buckets) {
            bucket.sort(Comparator.comparingInt(n -> n.val));

            sortedList.addAll(bucket);
        }

        ListNode head = sortedList.get(0);

        for (int i = 0; i < sortedList.size() - 1; i++) {
            sortedList.get(i).next = sortedList.get(i + 1);
        }

        return head;
    }

    private int hash(ListNode node, int max, int nBuckets) {
        double ratio = (double) (node.val / max);
        ratio = ratio < 0 ? 0 : ratio;
        return (int) ratio * (nBuckets + 1);
    }
}
