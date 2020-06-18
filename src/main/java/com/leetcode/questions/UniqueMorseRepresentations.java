package com.leetcode.questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueMorseRepresentations {
    private static final Map<Character, String> LOOK_UP = new HashMap<Character, String>() {{
        put('a', ".-");
        put('b', "-...");
        put('c', "-.-.");
        put('d', "-..");
        put('e', ".");
        put('f', "..-.");
        put('g', "--.");
        put('h', "....");
        put('i', "..");
        put('j', ".---");
        put('k', "-.-");
        put('l', ".-..");
        put('m', "--");
        put('n', "-.");
        put('o', "---");
        put('p', ".--.");
        put('q', "--.-");
        put('r', ".-.");
        put('s', "...");
        put('t', "-");
        put('u', "..-");
        put('v', "...-");
        put('w', ".--");
        put('x', "-..-");
        put('y', "-.--");
        put('z', "--..");
    }};

    public int solve(String[] words) {
        Set<String> set = new HashSet<>();

        for (String word : words) {
            StringBuilder stringBuilder = new StringBuilder();

            for (char c : word.toCharArray()) {
                stringBuilder.append(LOOK_UP.get(c));
            }

            set.add(stringBuilder.toString());
        }

        return set.size();
    }
}
