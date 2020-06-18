package com.leetcode.questions.tree;

/**
 * Given an array of numbers, verify whether it is the correct
 * preorder traversal sequence of a binary search tree.
 * <p>
 * You may assume each number in the sequence is unique.
 */
public class VerifyPreorderSequenceInBST {
    public boolean verifyPreorder(int[] preorder) {
        // given preorder[i], until preorder[j] where preorder[j] > preorder[i]
        // is found, every number in between them should be less than preorder[i]
        // and any preorder[n] where n >= j should be larger than preorder[i]
        return helper(preorder, 0, preorder.length);
    }

    private boolean helper(int[] preorder, int lo, int hi) {
        if (hi - lo <= 1) return true;
        int first = preorder[lo];
        // find the first number that is larger than preorder[lo]
        int i = lo + 1;

        while (i < hi) {
            if (preorder[i] > first) break;
            i++;
        }

        int tmp = i;
        // any node beyond this point must be larger than first
        while (tmp < hi) {
            if (preorder[tmp] < first) return false;
            tmp++;
        }

        return helper(preorder, lo + 1, i) && helper(preorder, i, hi);
    }
}
