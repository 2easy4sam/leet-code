package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;
import com.leetcode.questions.SerializeAndDeserializeBT;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SmallestSubtreeWithAllTheDeepestNodesTest {
    private SmallestSubtreeWithAllTheDeepestNodes smallestSubtreeWithAllTheDeepestNodes;
    private SerializeAndDeserializeBT serializeAndDeserializeBT;

    @Before
    public void setup() {
        smallestSubtreeWithAllTheDeepestNodes = new SmallestSubtreeWithAllTheDeepestNodes();
        serializeAndDeserializeBT = new SerializeAndDeserializeBT();
    }

    @Test
    public void test_1() {
        TreeNode head = serializeAndDeserializeBT.deserialize("[3,5,1,6,2,0,8,null,null,7,4]");

        head = smallestSubtreeWithAllTheDeepestNodes.subtreeWithAllDeepest(head);

        assertThat(head.val).isEqualTo(2);
        assertThat(head.left.val).isEqualTo(7);
        assertThat(head.right.val).isEqualTo(4);
    }
}