package com.leetcode.questions.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a string S, we can transform every letter individually to be
 * lowercase or uppercase to create another string.  Return a list of
 * all possible strings we could create.
 */
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        // think of this problem as a tree problem
        // we create an empty dummy root at the beginning
        // in each iteration, we append all the variants
        // i.e. lower and upper case of the next letter
        // to all previous permutations, and push them back
        // to the queue
        // the algorithm stops when it has exhausted the string
        // we then pop out all the leaf nodes (added in the last
        // interation), add them to a list
        List<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.offer("");

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            int size = q.size();

            for (int j = 0; j < size; j++) {
                String s = q.poll();

                q.offer(s + c);

                if (c > '9') {
                    // not a digit
                    if (c < 97) {
                        // upper case
                        q.offer(s + (char) (c + 32));
                    } else {
                        // lower case
                        q.offer(s + (char) (c - 32));
                    }
                }
            }
        }

        while (!q.isEmpty()) result.add(q.poll());

        return result;
    }
}
