package com.leetcode.questions;

import com.leetcode.datastructures.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PalindromeLinkedList {
    public boolean isPalindrome2(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            if (!list.get(i).equals(list.get(j))) return false;
        }

        return true;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        List<Integer> list1 = new ArrayList();
        List<Integer> list2 = new ArrayList();
        Set<Integer> set = new HashSet();

        while (head != null) {
            int val = head.val;

            if (!set.contains(val)) {
                list1.add(val);
                set.add(val);
            } else {
                list2.add(val);
                // look for its counterpart in list1
                int idx = list1.size() - list2.size();
                if (list1.get(idx) == val || list1.get(idx - 1) == val) {
                    // a pair is found
                    set.remove(val);
                } else {
                    return false;
                }
            }

            head = head.next;
        }

        return !list2.isEmpty() && list1.get(0).equals(list2.get(list2.size() - 1));
    }
}
