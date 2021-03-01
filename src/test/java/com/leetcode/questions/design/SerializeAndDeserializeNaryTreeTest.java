package com.leetcode.questions.design;

import com.leetcode.questions.design.SerializeAndDeserializeNaryTree.Node;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class SerializeAndDeserializeNaryTreeTest {
    private SerializeAndDeserializeNaryTree underTest;

    @Before
    public void setUp() {
        underTest = new SerializeAndDeserializeNaryTree();
    }

    @Test
    public void test_1() {
        Node root = new Node(1);
        Node child1 = new Node(3);
        root.children = Arrays.asList(child1, new Node(2), new Node(4));
        child1.children = Arrays.asList(new Node(5), new Node(6));

        String data = "1(3(5 6) 2 4)";

        assertThat(underTest.serialize(root)).isEqualTo(data);

        Node node = underTest.deserialize(data);
        assertThat(node.val).isEqualTo(1);
        assertThat(node.children.get(0).val).isEqualTo(3);
        assertThat(node.children.get(0).children.get(0).val).isEqualTo(5);
        assertThat(node.children.get(0).children.get(1).val).isEqualTo(6);
        assertThat(node.children.get(1).val).isEqualTo(2);
        assertThat(node.children.get(2).val).isEqualTo(4);
    }
}