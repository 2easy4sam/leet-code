package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SumRootToLeafNumbersTest {
    private SumRootToLeafNumbers sumRootToLeafNumbers;

    @Before
    public void setUp() {
        sumRootToLeafNumbers = new SumRootToLeafNumbers();
    }

    @Test
    public void test_1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        assertThat(sumRootToLeafNumbers.sumNumbers(root)).isEqualTo(25);
    }

    @Test
    public void test_2() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(0);

        assertThat(sumRootToLeafNumbers.sumNumbers(root)).isEqualTo(1026);
    }
}