package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class PreorderTraversalBSTTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private PreorderTraversalBST preorderTraversalBST;

    @Before
    public void setUpStreams() {
        preorderTraversalBST = new PreorderTraversalBST();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void test_1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);

        preorderTraversalBST.preorderTraversalRecur(root);

        assertThat(outContent.toString()).isEqualTo("1234");
    }
}