package com.leetcode.questions;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private Map<Integer, Integer> cache;
    private int capacity;

    /*
    operation               key,value                   cache
    put                     [1,1]                       [[1,1]]
    put                     [2,2]                       [[1,1],[2,2]]
    get                     1                           [[2,2],[1,1]]
    put                     [3,3]                       [[1,1],[3,3]]
    get                     2                           [[1,1],[3,3]]
    put                     [4,4]                       [[3,3],[4,4]]
    get                     1                           [[3,3],[4,4]]
    get                     3                           [[3,3],[4,4]]
    get                     4                           [[3,3],[4,4]]
    */

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        int value = cache.getOrDefault(key, -1);

        if (value > -1) {
            // cache exists, remove it and put it
            cache.remove(key);
            cache.put(key, value);
        }
        return value;
    }

    public void put(int key, int value) {
        /*
        -   IF key doesn't exist
            THEN we need to check if it has reached capacity already
        -   IF key exists
            THEN we need to remove the old entry and insert new entry
        */
        if (!cache.containsKey(key)) {
            // new entry
            if (cache.size() + 1 > capacity) {
                // remove LRU entry
                int lruKey = cache.keySet().iterator().next();
                cache.remove(lruKey);
            }
        } else {
            // existing entry
            cache.remove(key);
        }
        cache.put(key, value);
    }
}