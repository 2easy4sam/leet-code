package com.leetcode.questions.linkedlist;

import com.leetcode.questions.linkedlist.CopyListWithRandomPointer.Node;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CopyListWithRandomPointerTest {
    private CopyListWithRandomPointer copyListWithRandomPointer;

    @Before
    public void setUp() {
        copyListWithRandomPointer = new CopyListWithRandomPointer();
    }

    @Test
    public void test_1() {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);

        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        head = copyListWithRandomPointer.copyRandomList(head);

        assertThat(head.random).isNull();
        assertThat(head.next.random.val).isEqualTo(0);
        assertThat(head.next.next.random.val).isEqualTo(4);
        assertThat(head.next.next.next.random.val).isEqualTo(2);
        assertThat(head.next.next.next.next.random.val).isEqualTo(0);
    }
}