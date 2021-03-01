package com.leetcode.questions.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GeneralizedAbbreviation {
    private Set<String> res;

    /*
    - intuition:
        - from the example, we know that a valid abbreviation will never have two digits next to each other
        - a digit basically means how many following letters we need to skip
            - e.g. int "1ord", "o" is skipped here, the next abbreviation is "1o1d"
    */
    public List<String> generateAbbreviations(String word) {
        res = new HashSet<>();
        res.add(word);
        abbreviate(word, 0);

        return new ArrayList<>(res);
    }

    private void abbreviate(String curr, int index) {

        for (int i = index; i < curr.length(); i++) {
            int cnt = 1;

            while (i + cnt <= curr.length()) {
                String pt1 = curr.substring(0, i);
                String pt2 = curr.substring(i + cnt);
                StringBuilder next = new StringBuilder();
                next.append(pt1).append(cnt).append(pt2);
                res.add(next.toString());

                cnt++;

                if (i + cnt < curr.length()) {
                    abbreviate(next.toString(), Math.min(i + cnt, next.length() - 1));
                }
            }
        }
    }
}
