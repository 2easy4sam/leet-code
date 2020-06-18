package com.leetcode.questions;

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        // 1. build a regex
        StringBuilder sb = new StringBuilder();
        sb.append("([a-z]*");

        for (int i = 0; i < pattern.length(); i++) {
            sb.append(pattern.charAt(i)).append("[a-z]*");
        }

        sb.append(")");

        for (String query : queries) {
            ans.add(query.matches(sb.toString()));
        }

        return ans;
    }
}
