package com.leetcode.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharsByFrequency {
    public String frequencySort(String s) {
        // runtime: O(n)
        // space: O(c + n)
        // char <-> count
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : s.toCharArray())
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);

        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(frequencyMap.entrySet());

        entries.sort((e1, e2) -> e2.getValue() - e1.getValue());

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : entries) {
            for (int i = 0; i < entry.getValue(); i++) sb.append(entry.getKey());
        }

        return sb.toString();
    }
}
