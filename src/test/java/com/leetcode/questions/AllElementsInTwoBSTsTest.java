package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AllElementsInTwoBSTsTest {
    private AllElementsInTwoBSTs allElementsInTwoBSTs;

    @Before
    public void setUp() {
        allElementsInTwoBSTs = new AllElementsInTwoBSTs();
    }

    @Test
    public void test_1() {
        TreeNode t1 = new TreeNode(2);
        t1.left = new TreeNode(1);
        t1.right = new TreeNode(4);

        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(0);
        t2.right = new TreeNode(3);

        List<Integer> actual = allElementsInTwoBSTs.getAllElements2(t1, t2);

        assertThat(actual).containsExactly(0, 1, 1, 2, 3, 4);
    }

    @Test
    public void test_2() {
        TreeNode t1 = new TreeNode(1);
        t1.right = new TreeNode(8);

        TreeNode t2 = new TreeNode(8);
        t2.left = new TreeNode(1);

        List<Integer> actual = allElementsInTwoBSTs.getAllElements2(t1, t2);

        assertThat(actual).containsExactly(1, 1, 8, 8);
    }

    @Test
    public void test_3() {
        TreeNode t1 = new TreeNode(8);
        t1.left = new TreeNode(4);
        t1.right = new TreeNode(10);
        t1.left.left = new TreeNode(2);
        t1.left.right = new TreeNode(6);
        t1.right.right = new TreeNode(20);

        TreeNode t2 = new TreeNode(8);
        t2.left = new TreeNode(2);

        List<Integer> actual = allElementsInTwoBSTs.getAllElements2(t1, t2);

        assertThat(actual).containsExactly(2, 2, 4, 6, 8, 8, 10, 20);
    }
}