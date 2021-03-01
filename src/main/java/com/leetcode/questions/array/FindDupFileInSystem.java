package com.leetcode.questions.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDupFileInSystem {

    public List<List<String>> findDuplicate(String[] paths) {
        /*
        1. split each path by " " to see if there are mutiple files under the same dir
        2. use regex to extract the content of each file and put it in a HashMap as the key
        with the value being a list of paths that have the same content
        3. return the value set of the map
        */

        Map<String, List<String>> map = new HashMap<>();

        for (String path : paths) {
            String[] filePaths = path.split(" ");
            String root = filePaths[0];

            for (int i = 1; i < filePaths.length; i++) {
                String filePath = filePaths[i];
                int leftBracketIdx = filePath.indexOf("(");
                String content = filePath.substring(leftBracketIdx + 1, filePath.length() - 1);
                String cleaned = root + "/" + filePath.replaceAll("\\(.*\\)", "");

                if (map.containsKey(content)) {
                    map.get(content).add(cleaned);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(cleaned);
                    map.put(content, list);
                }
            }
        }

        return new ArrayList<>(map.values());
    }
}
