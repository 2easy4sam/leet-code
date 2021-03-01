package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EvenOddTreeTest {
    private EvenOddTree evenOddTree;

    @Before
    public void setUp() {
        evenOddTree = new EvenOddTree();
    }

    @Test
    public void test_1() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(7);

        assertThat(evenOddTree.isEvenOddTree(root)).isFalse();
    }
}