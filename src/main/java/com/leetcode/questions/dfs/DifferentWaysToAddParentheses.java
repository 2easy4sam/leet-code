package com.leetcode.questions.dfs;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        /*
        - assuming that the input is always valid, i.e. each sign has exactly 2 numbers on either side
        THEN we can keep track of the indexes of the signs
        e.g.
        01234
        1+2+3
        signs:      [1,3]
        numbers:    [0,2,4]
        we can pick 2 adjacent numbers as a pair each time say nums[j] and nums[j + 1], and the sign that joins them will be signs[j]
        [0,2]
        [2,4]

        once a pair is picked, we can then compute a new number, and form a new expression
        */
        List<Integer> res = new ArrayList<>();
        dfs(res, input);
        return res;
    }

    private void dfs(List<Integer> res, String input) {
        List<Integer> signIndexes = new ArrayList<>();

        for (int i = 0; i < input.length() - 1; i++) {
            if (!Character.isDigit(input.charAt(i))) {
                if (i > 0 && !Character.isDigit(input.charAt(i - 1)))
                    continue;
                signIndexes.add(i);
            }
        }

        List<Integer> nums = new ArrayList<>();
        int i = 0, j = 0;

        while (j < signIndexes.size()) {
            int signIndex = signIndexes.get(j);
            nums.add(Integer.parseInt(input.substring(i, signIndex)));
            i = signIndex + 1;
            j++;
        }

        // we are missing the last number
        nums.add(Integer.parseInt(input.substring(signIndexes.get(j - 1) + 1)));

        if (nums.size() == 2) {
            char sign = input.charAt(signIndexes.get(0));

            if (sign == '+') {
                res.add(nums.get(0) + nums.get(1));
            } else if (sign == '-') {
                res.add(nums.get(0) - nums.get(1));
            } else {
                res.add(nums.get(0) * nums.get(1));
            }
            return;
        }

        /*
        pick pairs
        */

        for (i = 0; i < nums.size() - 1; i++) {
            StringBuilder sb = new StringBuilder();

            int num1 = nums.get(i), num2 = nums.get(i + 1), signIndex = signIndexes.get(i);
            char sign = input.charAt(signIndex);

            int newNum;

            if (sign == '+') {
                newNum = num1 + num2;
            } else if (sign == '-') {
                newNum = num1 - num2;
            } else {
                newNum = num1 * num2;
            }

            // skip the picked numbers and sign, the new number should take the place of the ith number
            int index = 0;

            while (index < nums.size()) {
                if (index == i) {
                    sb.append(newNum);
                } else {
                    if (index != i + 1) sb.append(nums.get(index));
                    if (index < signIndexes.size()) {
                        sb.append(input.charAt(signIndexes.get(index)));
                    }
                }
                index++;
            }

            dfs(res, sb.toString());
        }
    }
}
