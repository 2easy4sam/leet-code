package com.leetcode.questions;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LRUCacheTest {
    private LRUCache lruCache;

    @Test
    public void test_1() {
        lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        assertThat(lruCache.get(1)).isEqualTo(1);
        lruCache.put(3, 3);
        assertThat(lruCache.get(2)).isEqualTo(-1);
        lruCache.put(4, 4);
        assertThat(lruCache.get(1)).isEqualTo(-1);
        assertThat(lruCache.get(3)).isEqualTo(3);
        assertThat(lruCache.get(4)).isEqualTo(4);
    }

    @Test
    public void test_2() {
        lruCache = new LRUCache(2);
        assertThat(lruCache.get(2)).isEqualTo(-1);
        lruCache.put(2, 6);
        assertThat(lruCache.get(1)).isEqualTo(-1);
        lruCache.put(1, 5);
        lruCache.put(1, 2);

    }
}