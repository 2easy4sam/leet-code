package com.leetcode.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommonChars {

    public List<String> commonChars(String[] A) {
        List<String> commonChars = new ArrayList<>();

        List<StringBuilder> stringBuilderList = Arrays.asList(A)
                .stream()
                .map(StringBuilder::new)
                .collect(Collectors.toList());

        StringBuilder shortest = stringBuilderList.get(0);

        for (StringBuilder sb : stringBuilderList) {
            if (sb.length() < shortest.length()) shortest = sb;
        }

        stringBuilderList.remove(shortest);

        for (int i = 0; i < shortest.length(); i++) {
            String c = Character.toString(shortest.charAt(i));

            boolean isCommonChar = true;

            for (StringBuilder sb : stringBuilderList) {
                int idx = sb.indexOf(c);

                if (idx != -1) {
                    sb.deleteCharAt(idx);
                } else {
                    isCommonChar = false;
                }
            }

            if (isCommonChar) commonChars.add(c);
        }

        return commonChars;
    }
}
