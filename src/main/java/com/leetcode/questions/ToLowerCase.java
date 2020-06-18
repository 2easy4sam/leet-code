package com.leetcode.questions;

public class ToLowerCase {
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder(str);

        for (int i = 0; i < str.length(); i++)
            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z')
                sb.setCharAt(i, (char) (str.charAt(i) | (char) 32));
        return sb.toString();
    }
}
