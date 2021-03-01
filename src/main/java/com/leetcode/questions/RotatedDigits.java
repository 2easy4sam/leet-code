package com.leetcode.questions;

import java.util.HashSet;
import java.util.Set;

public class RotatedDigits {

    public int rotatedDigits(int N) {
        /*
        - test cases:
            -   105
                digit       valid
                5           y
                0           n

                answer: 0
        - constraints/key words:
            - valid digits: [2,5,6,9]
        - thinking out loud:
            - check each number digit by digit
            - base case: N <= 1
        - time and space complexity:
            - time:
            - space:
        */

        if (N <= 1) return 0;

        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(5);
        set.add(6);
        set.add(9);

        int cnt = 0;

        for (int num = 2; num <= N; num++) {
            boolean valid = true;

            while (num != 0 && valid) {
                int remainder = num % 10;
                valid = set.contains(remainder);
                num /= 10;
            }

            if (valid) cnt++;
        }

        return cnt;
    }
}
