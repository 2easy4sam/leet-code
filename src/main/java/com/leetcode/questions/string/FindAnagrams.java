package com.leetcode.questions.string;

import java.util.*;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p.length() > s.length())
            return Collections.emptyList();

        Map<Character, Integer> m1 = new HashMap<>();

        for (char c : p.toCharArray()) {
            m1.put(c, m1.getOrDefault(c, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> m2 = new HashMap<>();
        int i = 0, j = 0;

        while (j < s.length()) {
            m2.put(s.charAt(j), m2.getOrDefault(s.charAt(j), 0) + 1);

            if (j - i + 1 == p.length()) {
                if (isAnagram(m1, m2)) res.add(i);
                m2.put(s.charAt(i), m2.get(s.charAt(i++)) - 1);
            }

            j++;
        }

        return res;
    }

    private boolean isAnagram(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        for (Map.Entry<Character, Integer> entry : m1.entrySet()) {
            if (!m2.containsKey(entry.getKey()) || !m2.get(entry.getKey()).equals(entry.getValue()))
                return false;
        }

        return true;
    }
}
