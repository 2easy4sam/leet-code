package com.leetcode.questions;

public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        // make sure str1 is always the longer string
        if (str1.length() < str2.length()) {
            String tmp = str1;
            str1 = str2;
            str2 = tmp;
        }

        String res = "";
        String sub = str1.substring(0, str2.length());

        if (sub.equals(str2)) {
            res = sub;

            while (sub.length() > 1 && str1.length() - str2.length() > 0) {

                sub = sub.substring(0, sub.length() - 1);

                int i = -1, j = -1;
                boolean stop = false;

                while (++j < str1.length() && !stop) {
                    i = ++i > sub.length() - 1 ? 0 : i;
                    stop = sub.charAt(i) != str1.charAt(j);
                }

                if (!stop) {
                    res = sub;

                    if (str1.length() % sub.length() == 0 && str1.length() / sub.length() > 1
                            && str2.length() % sub.length() == 0 && str2.length() / sub.length() > 1) {
                        break;
                    }
                }
            }
        }

        return res;
    }
}
