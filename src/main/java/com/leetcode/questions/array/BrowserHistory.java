package com.leetcode.questions.array;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {

    private List<String> history;

    private int curr, end;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        curr = 0;
        end = 0;
    }

    /*
    visit is normally an append-only operation. however, if the pointer is anywhere in between the first and last items in the history,
    visit should overwrite the current entry instead of appending
    */
    public void visit(String url) {
        if (curr + 1 == history.size()) {
            // curr is pointing to the last item in the history, append
            history.add(url);
            curr++;
        } else {
            history.add(++curr, url);
        }

        end = curr;
    }

    public String back(int steps) {
        curr = Math.max(0, curr - steps);
        return history.get(curr);
    }

    public String forward(int steps) {
        curr = Math.min(end, curr + steps);
        return history.get(curr);
    }
}
