package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;
import com.leetcode.questions.SerializeAndDeserializeBT;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AllNodesDistanceKInBTTest {
    private AllNodesDistanceKInBT allNodesDistanceKInBT;
    private SerializeAndDeserializeBT serializeAndDeserializeBT;

    @Before
    public void setup() {
        allNodesDistanceKInBT = new AllNodesDistanceKInBT();
        serializeAndDeserializeBT = new SerializeAndDeserializeBT();
    }

    @Test
    public void test_1() {
        TreeNode root = serializeAndDeserializeBT.deserialize("[3,5,1,6,2,0,8,null,null,7,4]");

        List<Integer> actual = allNodesDistanceKInBT.distanceK(root, new TreeNode(5), 2);

        assertThat(actual).containsExactly(7, 4, 1);
    }
}