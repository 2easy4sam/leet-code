package com.leetcode.questions;

import java.util.HashMap;
import java.util.Map;

public class DecryptStringFromAlphaToInt {
    private static final Map<String, String> numAlphaMap = new HashMap<>();

    static {
        numAlphaMap.put("1", "a");
        numAlphaMap.put("2", "b");
        numAlphaMap.put("3", "c");
        numAlphaMap.put("4", "d");
        numAlphaMap.put("5", "e");
        numAlphaMap.put("6", "f");
        numAlphaMap.put("7", "g");
        numAlphaMap.put("8", "h");
        numAlphaMap.put("9", "i");
        numAlphaMap.put("10#", "j");
        numAlphaMap.put("11#", "k");
        numAlphaMap.put("12#", "l");
        numAlphaMap.put("13#", "m");
        numAlphaMap.put("14#", "n");
        numAlphaMap.put("15#", "o");
        numAlphaMap.put("16#", "p");
        numAlphaMap.put("17#", "q");
        numAlphaMap.put("18#", "r");
        numAlphaMap.put("19#", "s");
        numAlphaMap.put("20#", "t");
        numAlphaMap.put("21#", "u");
        numAlphaMap.put("22#", "v");
        numAlphaMap.put("23#", "w");
        numAlphaMap.put("24#", "x");
        numAlphaMap.put("25#", "y");
        numAlphaMap.put("26#", "z");
    }

    public String freqAlphabets(String s) {
        final int len = s.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0, j = 3; j <= len; ) {
            String key = s.substring(i, j);

            if (numAlphaMap.containsKey(key)) {
                i = j;

                if (j + 3 > len) {
                    j++;
                } else {
                    j += 3;
                }
                sb.append(numAlphaMap.get(key));
            } else {
                j--;
            }
        }

        return sb.toString();
    }
}
