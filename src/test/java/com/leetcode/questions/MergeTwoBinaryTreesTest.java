package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MergeTwoBinaryTreesTest {
    private MergeTwoBinaryTrees mergeTwoBinaryTrees;

    @Before
    public void setUp() {
        mergeTwoBinaryTrees = new MergeTwoBinaryTrees();
    }

    @Test
    public void test() {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);

        TreeNode mergedTree = mergeTwoBinaryTrees.mergeTrees(t1, t2);

        assertThat(mergedTree.val).isEqualTo(3);
        assertThat(mergedTree.left.val).isEqualTo(4);
        assertThat(mergedTree.left.left.val).isEqualTo(5);
        assertThat(mergedTree.left.right.val).isEqualTo(4);
        assertThat(mergedTree.right.val).isEqualTo(5);
        assertThat(mergedTree.right.right.val).isEqualTo(7);
    }

    @Test
    public void test_2() {
        TreeNode t1 = new TreeNode(1);
        t1.right = new TreeNode(1);
        t1.right.right = new TreeNode(1);
        t1.right.right.right = new TreeNode(1);
        t1.right.right.right.right = new TreeNode(1);
        t1.right.right.right.right.right = new TreeNode(1);
        t1.right.right.right.right.right.right = new TreeNode(1);
        t1.right.right.right.right.right.right.right = new TreeNode(1);
        t1.right.right.right.right.right.right.right.right = new TreeNode(1);
        t1.right.right.right.right.right.right.right.right.right = new TreeNode(1);
        t1.right.right.right.right.right.right.right.right.right.right = new TreeNode(1);
        t1.right.right.right.right.right.right.right.right.right.right.left = new TreeNode(2);

        TreeNode t2 = new TreeNode(1);
        t2.right = new TreeNode(1);
        t2.right.right = new TreeNode(1);
        t2.right.right.right = new TreeNode(1);
        t2.right.right.right.right = new TreeNode(1);
        t2.right.right.right.right.right = new TreeNode(1);
        t2.right.right.right.right.right.left = new TreeNode(2);

        mergeTwoBinaryTrees.mergeTrees(t1, t2);
    }

    @Test
    public void test_3() {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.left.left = new TreeNode(3);

        TreeNode t2 = new TreeNode(1);
        t2.right = new TreeNode(2);
        t2.right.right = new TreeNode(3);

        TreeNode mergedTree = mergeTwoBinaryTrees.mergeTrees(t1, t2);

        assertThat(mergedTree.val).isEqualTo(2);
        assertThat(mergedTree.left.val).isEqualTo(2);
        assertThat(mergedTree.right.val).isEqualTo(2);
        assertThat(mergedTree.left.left.val).isEqualTo(3);
        assertThat(mergedTree.right.right.val).isEqualTo(3);
    }
}