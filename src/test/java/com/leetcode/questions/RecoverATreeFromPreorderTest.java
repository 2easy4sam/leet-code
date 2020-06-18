package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RecoverATreeFromPreorderTest {
    private RecoverATreeFromPreorder recoverATreeFromPreorder;

    @Before
    public void setUp() {
        recoverATreeFromPreorder = new RecoverATreeFromPreorder();
    }

    @Test
    public void test_1() {
        String tree = "1-2-5";

        TreeNode root = recoverATreeFromPreorder.recoverFromPreorder(tree);

        TreeNode expected = new TreeNode(1);
        expected.left = new TreeNode(2);
        expected.right = new TreeNode(5);

        assertThat(root).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    public void test_2() {
        String tree = "1-2--3--4-5--6--7";

        TreeNode root = recoverATreeFromPreorder.recoverFromPreorder(tree);

        TreeNode expected = new TreeNode(1);
        expected.left = new TreeNode(2);
        expected.right = new TreeNode(5);
        expected.left.left = new TreeNode(3);
        expected.left.right = new TreeNode(4);
        expected.right.left = new TreeNode(6);
        expected.right.right = new TreeNode(7);

        assertThat(root).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    public void test_3() {
        String tree = "1-2--3---4-5--6---7";

        TreeNode root = recoverATreeFromPreorder.recoverFromPreorder(tree);

        TreeNode expected = new TreeNode(1);
        expected.left = new TreeNode(2);
        expected.left.left = new TreeNode(3);
        expected.left.left.left = new TreeNode(4);
        expected.right = new TreeNode(5);
        expected.right.left = new TreeNode(6);
        expected.right.left.left = new TreeNode(7);

        assertThat(root).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    public void test_4() {
        String tree = "1-401--349---90--88";

        TreeNode root = recoverATreeFromPreorder.recoverFromPreorder(tree);

        TreeNode expected = new TreeNode(1);
        expected.left = new TreeNode(401);
        expected.left.left = new TreeNode(349);
        expected.left.right = new TreeNode(88);
        expected.left.left.left = new TreeNode(90);

        assertThat(root).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    public void test_5() {
        String tree = "8-6--9---10--4-7";

        TreeNode root = recoverATreeFromPreorder.recoverFromPreorder(tree);

        TreeNode expected = new TreeNode(8);
        expected.left = new TreeNode(6);
        expected.left.left = new TreeNode(9);
        expected.left.left.left = new TreeNode(10);
        expected.left.right = new TreeNode(4);
        expected.right = new TreeNode(7);

        assertThat(root).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    public void test_6() {
        String tree = "7-6--2--10---1----7-----4----10---4";

        TreeNode root = recoverATreeFromPreorder.recoverFromPreorder(tree);

        TreeNode expected = new TreeNode(7);
        expected.left = new TreeNode(6);
        expected.left.left = new TreeNode(2);
        expected.left.right = new TreeNode(10);
        expected.left.right.left = new TreeNode(1);
        expected.left.right.left.left = new TreeNode(7);
        expected.left.right.left.left.left = new TreeNode(4);
        expected.left.right.left.right = new TreeNode(10);
        expected.left.right.right = new TreeNode(4);

        assertThat(root).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    public void test_7() {
        String tree = "1";

        TreeNode root = recoverATreeFromPreorder.recoverFromPreorder(tree);

        TreeNode expected = new TreeNode(1);

        assertThat(root).isEqualToComparingFieldByFieldRecursively(expected);
    }
}