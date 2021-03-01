package com.leetcode.questions.dfs;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class NumberOfAtoms {
    /*
    - intuition:
        - scan from left to right
        - IF            formula[i] == (, find the matching )
          ELSE IF       formula[i] IS [a-zA-Z]
              THEN      keep iterating over formula until formula[i] IS NOT [a-zA-Z]
                AND     put elem into m if !m.containsKey(elem)
    */
    public String countOfAtoms(String formula) {
        // using a treemap as we need to keep res in lexicographical order
        Map<String, Integer> map = new TreeMap<>();

        count(map, formula, 1);

        // iterate over map, build the final res
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey()).append(entry.getValue() == 1 ? "" : entry.getValue());
        }

        return sb.toString();
    }

    private void count(Map<String, Integer> map, String f, int mult) {
        int i = 0;

        Map<String, Integer> localMap = new HashMap<>();
        StringBuilder elem = null;

        while (i < f.length()) {
            char c = f.charAt(i);

            if (c == '(') {
                if (elem != null) {
                    put(localMap, elem.toString(), mult);
                    elem = null;
                }

                int cnt = 1, begin = i + 1;
                // find the matching )
                while (cnt != 0 && ++i < f.length()) {
                    if (f.charAt(i) == '(') cnt++;
                    else if (f.charAt(i) == ')') cnt--;
                }

                // i is now pointing at a ), it may be followed by a multiplier
                // check if there's a multiplier
                int end = i;
                int nextMult = 1;

                if (++i < f.length() && Character.isDigit(f.charAt(i))) {
                    int mBegin = i;

                    while (i < f.length() && Character.isDigit(f.charAt(i))) {
                        i++;
                    }

                    nextMult = Integer.parseInt(f.substring(mBegin, i)) * mult;
                }

                count(map, f.substring(begin, end), nextMult);
            } else if (Character.isDigit(c)) {
                // if it's a digit, then it is a multiplier for the element
                // that we just built
                int begin = i;

                while (i < f.length() && Character.isDigit(f.charAt(i))) {
                    i++;
                }

                int cnt = Integer.parseInt(f.substring(begin, i)) * mult;

                put(localMap, elem.toString(), cnt);
                elem = null;
            } else {
                // neither a ( nor [0-9]
                if (elem == null) elem = new StringBuilder();
                else if (Character.isUpperCase(c)) {
                    // the current char is in upper case, start anew
                    // but before then, put the previous elem into localMap
                    put(localMap, elem.toString(), mult);
                    elem = new StringBuilder();
                }
                elem.append(c);
                i++;
            }
        } // END OF WHILE

        if (elem != null) {
            put(localMap, elem.toString(), mult);
        }

        // put everything in local map to master map
        for (Map.Entry<String, Integer> entry : localMap.entrySet()) {
            map.put(entry.getKey(), map.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }
    }

    private void put(Map<String, Integer> map, String elem, int cnt) {
        if (map.containsKey(elem)) {
            map.put(elem, map.get(elem) + cnt);
        } else {
            map.put(elem, cnt);
        }
    }
}
