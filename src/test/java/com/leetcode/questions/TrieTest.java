package com.leetcode.questions;

import com.leetcode.datastructures.Trie;
import com.leetcode.datastructures.Trie.TrieNode;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TrieTest {

    @Test
    public void test_1() {
        Trie trie = new Trie();

        trie.insert("hello");

        assertThat(trie.search("hello")).isTrue();
        assertThat(trie.startsWith("hell")).isTrue();
        assertThat(trie.search("world")).isFalse();
        assertThat(trie.startsWith("ello")).isFalse();
    }

    @Test
    public void test_2() {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("boy");

        assertThat(trie.search("apple")).isTrue();
        assertThat(trie.search("boy")).isTrue();
        assertThat(trie.search("app")).isFalse();
        assertThat(trie.search("bo")).isFalse();
    }

    @Test
    public void test_3() {
        Trie trie = new Trie();

        trie.insert("app");
        trie.insert("aqua");
        trie.insert("abomination");

        assertThat(trie.startsWith("ap")).isTrue();
        assertThat(trie.startsWith("aq")).isTrue();
        assertThat(trie.startsWith("ab")).isTrue();
    }

    @Test
    public void test_isAlphabeticallyLower() {
        String s1 = "abcde";
        String s2 = "abcdf";

        Trie trie = new Trie();

        TrieNode t1 = trie.createTrieNode(s1);
        TrieNode t2 = trie.createTrieNode(s2);

        assertThat(t1.isAlphabeticallyLower(t2)).isTrue();
    }
}