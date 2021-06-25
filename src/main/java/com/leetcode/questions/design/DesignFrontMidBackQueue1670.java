package com.leetcode.questions.design;

import java.util.ArrayList;
import java.util.List;

public class DesignFrontMidBackQueue1670 {
    private List<Integer> list;

    public DesignFrontMidBackQueue1670() {
        list = new ArrayList<>();
    }

    public void pushFront(int val) {
        list.add(0, val);
    }

    public void pushMiddle(int val) {
        int mid = list.size() / 2;
        list.add(mid, val);
    }

    public void pushBack(int val) {
        list.add(list.size(), val);
    }

    public int popFront() {
        if (list.isEmpty()) return -1;
        int val = list.get(0);
        list = list.subList(1, list.size());
        return val;
    }

    public int popMiddle() {
        if (list.isEmpty()) return -1;
        int mid = list.size() / 2 - (list.size() % 2 == 0 ? 1 : 0);
        int val = list.get(mid);
        List<Integer> tmp = list.subList(0, mid);
        tmp.addAll(list.subList(mid + 1, list.size()));
        list = tmp;
        return val;
    }

    public int popBack() {
        if (list.isEmpty()) return -1;
        int val = list.get(list.size() - 1);
        list = list.subList(0, list.size() - 1);
        return val;
    }
}
