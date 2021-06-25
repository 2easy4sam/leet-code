package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;
import com.leetcode.questions.SerializeAndDeserializeBT;
import org.junit.Before;
import org.junit.Test;

public class RecoverBST99Test {
    private RecoverBST99 underTest;
    private SerializeAndDeserializeBT helper;

    @Before
    public void setUp() {
        underTest = new RecoverBST99();
        helper = new SerializeAndDeserializeBT();
    }

    @Test
    public void test_1() {
        TreeNode root = helper.deserialize("[4,2,null,1,null,null,3]");

        underTest.recoverTree(root);
    }
}