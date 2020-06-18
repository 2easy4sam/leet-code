package com.leetcode.questions;

import com.leetcode.datastructures.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PartitionListTest {
    private PartitionList partitionList;

    @Before
    public void setUp() {
        partitionList = new PartitionList();
    }

    @Test
    public void test_1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        ListNode newHead = partitionList.partition(head, 3);

        assertThat(newHead.val).isEqualTo(1);
    }

    @Test
    public void test_2() {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);

        ListNode newHead = partitionList.partition(head, 2);

        assertThat(newHead.val).isEqualTo(1);
        assertThat(newHead.next.val).isEqualTo(2);
    }

    @Test
    public void test_3() {
        ListNode head = new ListNode(1);

        ListNode newHead = partitionList.partition(head, 0);

        assertThat(newHead.val).isEqualTo(1);
    }

    @Test
    public void test_4() {
        ListNode head = new ListNode(1);

        ListNode newHead = partitionList.partition(head, 1);

        assertThat(newHead.val).isEqualTo(1);
    }
}