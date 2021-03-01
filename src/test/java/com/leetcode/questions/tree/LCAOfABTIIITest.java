package com.leetcode.questions.tree;

import com.leetcode.datastructures.DLNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LCAOfABTIIITest {
    private LCAOfABTIII lcaOfABTIII;

    @Before
    public void setUp() {
        lcaOfABTIII = new LCAOfABTIII();
    }

    @Test
    public void test_1() {
        DLNode root = new DLNode(3);
        DLNode five = root.setLeft(5);
        DLNode six = five.setLeft(6);
        DLNode one = root.setRight(1);
        DLNode two = five.setRight(2);
        DLNode seven = two.setLeft(7);
        DLNode four = two.setRight(4);
        one.setLeft(0);
        one.setRight(8);

        assertThat(lcaOfABTIII.lowestCommonAncestor(root, root.left.right.right)).isEqualTo(root);
    }
}