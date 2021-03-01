package com.leetcode.questions.string;

import java.util.HashMap;
import java.util.Map;

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        /*
        - test cases:
            -   abcd
                dcba

            -   ab-cd
                dc-ba

                i                       stringbuilder           q
                0                       a                       []
                1                       ab                      []
                2                       ab                      [[-,2]]
                3                       abc                     [[-,2]]
                4                       abcd                    [[-,2]]
        - thinking out loud:
            - could use a stringbuilder to holder all letters
            reverse the stringbuilder
            anything that is not a letter, push [letter, index] into a queue
            after reversing the stringbuilder, pop all items from queue and
            insert them into the stringbuilder
        - constraints/key words:
            - contains not only letters
            - lowercase + uppercase
            - length <= 100
            - could be null or empty
        - time and space complexity:
            - time:
            - space:
        */

        if (S == null || S.length() == 0) return S;

        StringBuilder sb = new StringBuilder();
        // index <-> char
        Map<Integer, Character> map = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (isLetter(c)) sb.append(c);
            else map.put(i, c);
        }

        sb.reverse();

        for (Map.Entry<Integer, Character> entry : map.entrySet()) {
            sb.insert((int) entry.getKey(), (char) entry.getValue());
        }

        return sb.toString();
    }

    private boolean isLetter(char c) {
        int lower = c - 'a';
        int upper = c - 'A';
        return (lower >= 0 && lower < 26) || (upper >= 0 && upper < 26);
    }
}
