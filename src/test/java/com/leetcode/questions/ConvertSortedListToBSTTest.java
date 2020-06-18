package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static com.leetcode.questions.ConvertSortedListToBST.ListNode;

public class ConvertSortedListToBSTTest {
    private ConvertSortedListToBST convertSortedListToBST;

    @Before
    public void setUp() {
        convertSortedListToBST = new ConvertSortedListToBST();
    }

    @Test
    public void test_1() {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        TreeNode newHead = convertSortedListToBST.sortedListToBST(head);
    }

    @Test
    public void test_2() {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(20);

        TreeNode newHead = convertSortedListToBST.sortedListToBST(head);
    }
}