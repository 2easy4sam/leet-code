package com.leetcode.questions.string;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<StringBuilder> tmp = new ArrayList<>();
        int i = 0, curLen = 0;

        while (i < words.length) {
            curLen += words[i].length();
            tmp.add(new StringBuilder(words[i]));

            if (curLen == maxWidth) {
                curLen = 0;
                addAllToRes(res, tmp);

                i++;
            } else if (curLen > maxWidth) {
                // remove the last entry and remove a space
                curLen = curLen - tmp.get(tmp.size() - 1).length() - 1;
                tmp.remove(tmp.size() - 1);
                removeLastSpace(tmp);

                // now fill up the sentence with spaces until max width is reached
                int idx = 0;

                while (curLen != maxWidth) {
                    idx %= Math.max(1, (tmp.size() - 1));

                    tmp.get(idx).append(" ");
                    curLen++;

                    idx++;
                }

                addAllToRes(res, tmp);

                curLen = 0;
            } else {
                // curLen < maxWidth
                curLen++;
                appendSpace(tmp);

                // need to check if this is the last word
                // if so, append spaces till the length == maxWidth
                if (i == words.length - 1) {
                    while (curLen != maxWidth) {
                        appendSpace(tmp);
                        curLen++;
                    }

                    addAllToRes(res, tmp);
                }

                i++;
            }
        }

        return res;
    }

    private void addAllToRes(List<String> res, List<StringBuilder> tmp) {
        StringBuilder sentence = tmp.get(0);

        for (int i = 1; i < tmp.size(); i++) {
            sentence.append(tmp.get(i));
        }

        res.add(sentence.toString());
        tmp.clear();
    }

    // get the last added word, append a space to it
    private void appendSpace(List<StringBuilder> words) {
        words.get(words.size() - 1).append(" ");
    }

    // remove a space from the last added word
    private void removeLastSpace(List<StringBuilder> words) {
        StringBuilder last = words.get(words.size() - 1);
        last.deleteCharAt(last.length() - 1);
        words.set(words.size() - 1, last);
    }
}
