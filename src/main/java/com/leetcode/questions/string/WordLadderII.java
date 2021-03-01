package com.leetcode.questions.string;

import java.util.*;

public class WordLadderII {
    private Map<String, List<String>> map;
    private List<List<String>> results;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        results = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);

        if (dict.size() == 0 || !dict.contains(endWord))
            Collections.emptyList();

        int min = Integer.MAX_VALUE;

        map = new HashMap<>();

        Map<String, Integer> ladder = new HashMap<>();

        for (String str : dict) {
            // use infinity to denote that a node hasn't been visited
            ladder.put(str, Integer.MAX_VALUE);
        }
        ladder.put(beginWord, 0);

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        // BFS: Dijkstra search
        while (!q.isEmpty()) {
            String word = q.poll();

            // 'step' indicates how many steps are needed to travel to one word.
            int steps = ladder.get(word) + 1;

            if (steps > min) break;

            // generate all possible permutations of the current word
            for (int i = 0; i < word.length(); i++) {
                char[] charArr = word.toCharArray();

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    charArr[i] = ch;
                    String newWord = new String(charArr);

                    // check if the permutation is actually in the dict
                    if (ladder.containsKey(newWord)) {

                        // Check if it is the shortest path to one word.
                        if (steps > ladder.get(newWord)) continue;
                        else if (steps < ladder.get(newWord)) {
                            q.add(newWord);
                            // now that a node has been visited
                            // change the distance from beginWord to it
                            // from infinity (i.e. unvisited) to the actual
                            // number of steps
                            ladder.put(newWord, steps);
                        }

                        List<String> list = map.getOrDefault(newWord, new LinkedList<>());
                        list.add(word);
                        map.put(newWord, list);

                        /*
                        now that we have reached the destination
                        set min to the steps taken so far so that
                        any nodes that haven't been visited yet will
                        break the loop (i.e. infinity > min)
                        */
                        if (newWord.equals(endWord)) min = steps;
                    }
                }
            }
        }

        // BackTracking
        backTrace(endWord, beginWord, new LinkedList<>());

        return results;
    }

    private void backTrace(String currWord, String beginWord, List<String> ladder) {
        if (currWord.equals(beginWord)) {
            ladder.add(0, beginWord);
            results.add(new ArrayList<>(ladder));
            ladder.remove(0);
            return;
        }

        ladder.add(0, currWord);

        if (map.get(currWord) != null) {
            for (String s : map.get(currWord)) {
                backTrace(s, beginWord, ladder);
            }
        }
        ladder.remove(0);
    }
}