package com.leetcode.questions.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SentenceScreenFitting {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        /*
            I-had
            apple
            pie-I
            had--
            apple
            pie--
            I-had
            apple
            pie-I
            had--
            apple
            pie--

            a-bcd-
            e-a---
            bcd-e-
            a-bcd-
            e-a---
            bcd-e-

            a-bcd
            e-a--
            bcd-e
            a-bcd
            e-a--
            bcd-e

            - the sentence is said to be fitted on the screen IF and only IF last word has been displayed
            on the screen
            - the frequency that a line that starts with the first word in the sentence appears is fixed, call denote this sentence `firstLine`
            - the distance between lines that contains the last word in the sentence and `firstLine` is also fixed
        */

        Set<String> set = new HashSet<>();
        List<Integer> distToFirstLine = new ArrayList<>();
        int wordIdx = 0, nWords = sentence.length;

        for (int row = 0; row < rows; row++) {
            StringBuilder sb = new StringBuilder();

            while (sb.length() < cols) {
                String word = sentence[wordIdx];
                int newLen = sb.length() + word.length();
                if (newLen > cols) {
                    int i = sb.length();
                    while (i++ < cols) sb.append("-");
                    break;
                }
                sb.append(word);
                if (sb.length() < cols) sb.append("-");
                if (wordIdx == nWords - 1) {
                    distToFirstLine.add(row);
                }
                wordIdx = (wordIdx + 1) % nWords;
            }

            if (!set.add(sb.toString())) {
                // the first line has appeared twice
                break;
            }
        }

        int freq = set.size();
        int cnt = rows / freq;
        int remainder = rows % freq;

        if (freq == rows) {
            // this means we've just managed to complete 1 full cycle
            return distToFirstLine.size();
        }

        for (int dist : distToFirstLine) {
            if (remainder > dist) cnt++;
        }

        return cnt;
    }
}
