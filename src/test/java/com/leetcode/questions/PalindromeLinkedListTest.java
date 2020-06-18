package com.leetcode.questions;

import com.leetcode.datastructures.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PalindromeLinkedListTest {
    private PalindromeLinkedList palindromeLinkedList;

    @Before
    public void setUp() {
        palindromeLinkedList = new PalindromeLinkedList();
    }

    @Test
    public void test_1() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);

        assertThat(palindromeLinkedList.isPalindrome(listNode)).isFalse();
    }

    @Test
    public void test_2() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(1);

        assertThat(palindromeLinkedList.isPalindrome(listNode)).isTrue();
    }

    @Test
    public void test_3() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(1);

        assertThat(palindromeLinkedList.isPalindrome(listNode)).isTrue();
    }

    @Test
    public void test_4() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(2);
        listNode.next.next.next.next.next = new ListNode(1);

        assertThat(palindromeLinkedList.isPalindrome(listNode)).isFalse();
    }

    @Test
    public void test_5() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(2);
        listNode.next.next.next.next.next = new ListNode(1);

        assertThat(palindromeLinkedList.isPalindrome(listNode)).isTrue();
    }

    @Test
    public void test_6() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next.next = new ListNode(3);
        listNode.next.next.next.next.next.next.next = new ListNode(2);
        listNode.next.next.next.next.next.next.next.next = new ListNode(1);

        assertThat(palindromeLinkedList.isPalindrome(listNode)).isTrue();
    }

    @Test
    public void test_7() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);

        assertThat(palindromeLinkedList.isPalindrome(listNode)).isFalse();
    }

    @Test
    public void test_8() {
        ListNode listNode = new ListNode(1);

        assertThat(palindromeLinkedList.isPalindrome(listNode)).isTrue();
    }

    @Test
    public void test_9() {
        assertThat(palindromeLinkedList.isPalindrome(null)).isTrue();
    }

    @Test
    public void test_10() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(0);
        listNode.next.next = new ListNode(0);

        assertThat(palindromeLinkedList.isPalindrome(listNode)).isFalse();
    }

    @Test
    public void test_11() {
        ListNode listNode = new ListNode(-129);
        listNode.next = new ListNode(-129);

        assertThat(palindromeLinkedList.isPalindrome(listNode)).isTrue();
    }
}