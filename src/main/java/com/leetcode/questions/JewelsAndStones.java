package com.leetcode.questions;

/**
 * @see <a href="https://leetcode.com/problems/jewels-and-stones/">771</a>
 */
public class JewelsAndStones {

    public int solve(String j, String s) {
        return s.replaceAll("[^" + j + "]", "").length();
    }
}
