package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;
import com.leetcode.questions.SerializeAndDeserializeBT;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CBTInserterTest {
    private CBTInserter cbtInserter;
    private SerializeAndDeserializeBT serializeAndDeserializeBT;

    @Before
    public void setup() {
        serializeAndDeserializeBT = new SerializeAndDeserializeBT();
    }

    @Test
    public void test_1() {
        String data = "[1,2,3,4,5,6,7]";
        TreeNode root = serializeAndDeserializeBT.deserialize(data);

        cbtInserter = new CBTInserter(root);
        cbtInserter.insert(8);
        cbtInserter.insert(9);
        cbtInserter.insert(10);
        cbtInserter.insert(11);
        cbtInserter.insert(12);
        cbtInserter.insert(13);
        cbtInserter.insert(14);

        root = cbtInserter.get_root();

        assertThat(root.val).isEqualTo(1);
    }
}