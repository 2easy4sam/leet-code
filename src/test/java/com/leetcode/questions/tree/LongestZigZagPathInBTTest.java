package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;
import com.leetcode.questions.SerializeAndDeserializeBT;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestZigZagPathInBTTest {
    private LongestZigZagPathInBT longestZigZagPathInBT;
    private SerializeAndDeserializeBT serializeAndDeserializeBT;

    @Before
    public void setup() {
        longestZigZagPathInBT = new LongestZigZagPathInBT();
        serializeAndDeserializeBT = new SerializeAndDeserializeBT();
    }

    @Test
    public void test_1() {
        String serialized = "[1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]";
        TreeNode root = serializeAndDeserializeBT.deserialize(serialized);

        int max = longestZigZagPathInBT.longestZigZag(root);

        assertThat(max).isEqualTo(3);
    }
}