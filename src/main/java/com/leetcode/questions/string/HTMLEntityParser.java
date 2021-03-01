package com.leetcode.questions.string;

import java.util.HashMap;
import java.util.Map;

public class HTMLEntityParser {
    public String entityParser(String text) {
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = new HashMap<>();

        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");

        int i = 0, j;

        while (i < text.length()) {
            if (text.charAt(i) == '&') {
                j = text.indexOf(';', i);

                if (j > i) {
                    String sub = text.substring(i, j + 1);

                    if (map.containsKey(sub)) {
                        sb.append(map.get(sub));
                        i = j + 1;
                        continue;
                    }
                }
            }

            sb.append(text.charAt(i++));
        }

        return sb.toString();
    }
}
