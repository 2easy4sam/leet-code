package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubtreeOfAnotherTreeTest {
    private SubtreeOfAnotherTree subtreeOfAnotherTree;

    @Before
    public void setUp() {
        subtreeOfAnotherTree = new SubtreeOfAnotherTree();
    }

    @Test
    public void test_1() {
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        boolean actual = subtreeOfAnotherTree.isSubtree2(s, t);

        assertThat(actual).isTrue();
    }

    @Test
    public void test_2() {
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        s.left.right.left = new TreeNode(0);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        boolean actual = subtreeOfAnotherTree.isSubtree2(s, t);

        assertThat(actual).isFalse();
    }

    @Test
    public void test_3() {
        TreeNode s = null;

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        boolean actual = subtreeOfAnotherTree.isSubtree2(s, t);

        assertThat(actual).isFalse();
    }

    @Test
    public void test_4() {
        TreeNode t = null;

        TreeNode s = new TreeNode(4);
        s.left = new TreeNode(1);
        s.right = new TreeNode(2);

        boolean actual = subtreeOfAnotherTree.isSubtree2(s, t);

        assertThat(actual).isFalse();
    }

    @Test
    public void test_5() {
        TreeNode t = null;
        TreeNode s = null;

        boolean actual = subtreeOfAnotherTree.isSubtree2(s, t);

        assertThat(actual).isTrue();
    }

    @Test
    public void test_6() {
        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(2);
        s.right = new TreeNode(3);

        s.left.left = new TreeNode(4);
        s.left.right = new TreeNode(5);

        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(3);
        t.right = new TreeNode(2);

        boolean actual = subtreeOfAnotherTree.isSubtree2(s, t);

        assertThat(actual).isFalse();
    }
}