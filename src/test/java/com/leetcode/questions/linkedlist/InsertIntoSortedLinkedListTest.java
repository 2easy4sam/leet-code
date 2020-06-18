package com.leetcode.questions.linkedlist;

import com.leetcode.datastructures.Node;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InsertIntoSortedLinkedListTest {
    private InsertIntoSortedLinkedList insertIntoSortedLinkedList;

    @Before
    public void setUp() {
        insertIntoSortedLinkedList = new InsertIntoSortedLinkedList();
    }

    @Test
    public void test_1() {
        Node head = new Node(3);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = head;

        head = insertIntoSortedLinkedList.insert(head, 0);

        assertThat(head.val).isEqualTo(3);
        assertThat(head.next.val).isEqualTo(3);
        assertThat(head.next.next.val).isEqualTo(5);
        assertThat(head.next.next.next.val).isEqualTo(0);
    }
}