package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckCompletenessOfBTTest {
    private CheckCompletenessOfBT checkCompletenessOfBT;

    @Before
    public void setUp() {
        checkCompletenessOfBT = new CheckCompletenessOfBT();
    }

    @Test
    public void test_1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        assertThat(checkCompletenessOfBT.isCompleteTree(root)).isTrue();
    }

    @Test
    public void test_2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);

        assertThat(checkCompletenessOfBT.isCompleteTree(root)).isFalse();
    }

    @Test
    public void test_3() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);

        assertThat(checkCompletenessOfBT.isCompleteTree(root)).isFalse();
    }

    @Test
    public void test_4() {
        TreeNode root = null;

        assertThat(checkCompletenessOfBT.isCompleteTree(root)).isTrue();
    }

    @Test
    public void test_5() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(8);

        assertThat(checkCompletenessOfBT.isCompleteTree(root)).isFalse();
    }

    @Test
    public void test_6() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(6);

        assertThat(checkCompletenessOfBT.isCompleteTree(root)).isTrue();
    }

    @Test
    public void test_7() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);

        assertThat(checkCompletenessOfBT.isCompleteTree(root)).isFalse();
    }

    @Test
    public void test_8() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);

        assertThat(checkCompletenessOfBT.isCompleteTree(root)).isFalse();
    }
}