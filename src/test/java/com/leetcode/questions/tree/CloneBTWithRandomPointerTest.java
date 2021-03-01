package com.leetcode.questions.tree;

import com.leetcode.questions.tree.CloneBTWithRandomPointer.RandomNode;
import org.junit.Before;
import org.junit.Test;

public class CloneBTWithRandomPointerTest {
    private CloneBTWithRandomPointer underTest;

    @Before
    public void setUp() {
        underTest = new CloneBTWithRandomPointer();
    }

    @Test
    public void test_1() {
        RandomNode root = new RandomNode(1);
        root.right = new RandomNode(4);
        root.right.left = new RandomNode(7);
        root.right.random = root.right.left;
        root.right.left.random = root;

        RandomNode actual = underTest.copyRandomBinaryTree(root);
    }
}