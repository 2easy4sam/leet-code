package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConstructBinaryTreeFromStringTest {
    private ConstructBinaryTreeFromString constructBinaryTreeFromString;

    @Before
    public void setUp() {
        constructBinaryTreeFromString = new ConstructBinaryTreeFromString();
    }

    @Test
    public void test_1() {
        String s = "4(2(3)(1))(6(5))";

        TreeNode root = constructBinaryTreeFromString.str2tree(s);

        assertThat(root.val).isEqualTo(4);
        assertThat(root.left.val).isEqualTo(2);
        assertThat(root.left.left.val).isEqualTo(3);
        assertThat(root.left.right.val).isEqualTo(1);
        assertThat(root.right.val).isEqualTo(6);
        assertThat(root.right.left.val).isEqualTo(5);
    }

    @Test
    public void test_2() {
        String s = "4(1)(2)";

        TreeNode root = constructBinaryTreeFromString.str2tree(s);

        assertThat(root.val).isEqualTo(4);
        assertThat(root.left.val).isEqualTo(1);
        assertThat(root.right.val).isEqualTo(2);
    }

    @Test
    public void test_3() {
        String s = "6(5(4(3(2(1)))))";

        TreeNode root = constructBinaryTreeFromString.str2tree(s);

        assertThat(root.val).isEqualTo(6);
        assertThat(root.left.val).isEqualTo(5);
        assertThat(root.left.left.val).isEqualTo(4);
        assertThat(root.left.left.left.val).isEqualTo(3);
        assertThat(root.left.left.left.left.val).isEqualTo(2);
        assertThat(root.left.left.left.left.left.val).isEqualTo(1);
    }
}