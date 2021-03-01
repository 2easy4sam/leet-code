package com.leetcode.questions.string;

import java.util.HashMap;
import java.util.Map;

/*
Given a balanced parentheses string S, compute the score of the string
based on the following rule:

    - () has score 1
    - AB has score A + B, where A and B are balanced parentheses
    strings.
    - (A) has score 2 * A, where A is a balanced parentheses string.
*/
public class ScoreOfParentheses {
    public int scoreOfParentheses(String S) {
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (char c : S.toCharArray()) {
            if (c == '(') {
                if (!map.containsKey(++cnt)) {
                    map.put(cnt, 0);
                }
            } else {
                if (map.containsKey(cnt + 1)) {
                    map.put(cnt, map.get(cnt) + map.get(cnt + 1) * 2);
                    map.remove(cnt + 1);
                } else {
                    map.put(cnt, map.get(cnt) + 1);
                }
                cnt--;
            }
        }

        return map.get(1);
    }
}
