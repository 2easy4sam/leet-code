package com.leetcode.questions.bst;

import com.leetcode.datastructures.TreeNode;
import com.leetcode.questions.SerializeAndDeserializeBT;
import org.junit.Before;
import org.junit.Test;

public class DeleteNodeInBSTTest {
    private DeleteNodeInBST deleteNodeInBST;
    private SerializeAndDeserializeBT serializeAndDeserializeBT;

    @Before
    public void setUp() {
        deleteNodeInBST = new DeleteNodeInBST();
        serializeAndDeserializeBT = new SerializeAndDeserializeBT();
    }

    @Test
    public void test_1() {
        String data = "[2,0,33,null,1,25,40,null,null,11,31,34,45,10,18,29,32,null,36,43,46,4,null,12,24,26,30,null,null,35,39,42,44,null,48,3,9,null,14,22,null,null,27,null,null,null,null,38,null,41,null,null,null,47,49,null,null,5,null,13,15,21,23,null,28,37,null,null,null,null,null,null,null,null,8,null,null,null,17,19,null,null,null,null,null,null,null,7,null,16,null,null,20,6]";
        TreeNode root = serializeAndDeserializeBT.deserialize(data);

        deleteNodeInBST.deleteNode(root, 33);
    }
}