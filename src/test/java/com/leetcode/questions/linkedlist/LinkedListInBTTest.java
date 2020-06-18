package com.leetcode.questions.linkedlist;

import com.leetcode.datastructures.ListNode;
import com.leetcode.datastructures.TreeNode;
import com.leetcode.questions.SerializeAndDeserializeBT;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListInBTTest {
    private LinkedListInBT linkedListInBT;
    private SerializeAndDeserializeBT serializeAndDeserializeBT;

    @Before
    public void setup() {
        linkedListInBT = new LinkedListInBT();
        serializeAndDeserializeBT = new SerializeAndDeserializeBT();
    }

    @Test
    public void test_1() {
        String btString = "[1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]";
        TreeNode root = serializeAndDeserializeBT.deserialize(btString);

        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(3);

        assertThat(linkedListInBT.isSubPath(head, root)).isTrue();
    }

    @Test
    public void test_2() {
        String btString = "[1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]";
        TreeNode root = serializeAndDeserializeBT.deserialize(btString);

        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(8);

        assertThat(linkedListInBT.isSubPath(head, root)).isTrue();
    }

    @Test
    public void test_withOnlyLeftBranch() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(2);
        root.left.left.left.left = new TreeNode(3);

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(4);

        assertThat(linkedListInBT.isSubPath(head1, root)).isTrue();
        assertThat(linkedListInBT.isSubPath(head2, root)).isFalse();
    }

    @Test
    public void test_withSingleElementList() {
        TreeNode root = serializeAndDeserializeBT.deserialize("[1,5,3,null,4,null,3]");

        ListNode head = new ListNode(3);

        assertThat(linkedListInBT.isSubPath(head, root)).isTrue();
    }
}