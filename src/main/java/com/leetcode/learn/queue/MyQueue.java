package com.leetcode.learn.queue;

import java.util.ArrayList;
import java.util.List;

public class MyQueue<T> {
    private List<T> data;
    private int startIdx;

    public MyQueue() {
        this.data = new ArrayList<>();
        startIdx = 0;
    }

    public boolean enQueue(T element) {
        data.add(element);
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        startIdx++;
        return true;
    }

    public T front() {
        return data.get(startIdx);
    }

    public boolean isEmpty() {
        return startIdx >= data.size();
    }
}
