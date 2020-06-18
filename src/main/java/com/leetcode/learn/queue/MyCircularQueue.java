package com.leetcode.learn.queue;

import java.util.ArrayList;
import java.util.List;

public class MyCircularQueue {
    private int head, tail;
    private int size;
    private List<Integer> data;

    public MyCircularQueue(int size) {
        this.size = size;
        this.data = new ArrayList<>(size);
        this.head = 0;
        this.tail = -1;
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    public boolean isFull() {
        return this.data.size() == this.size;
    }

    public boolean enQueue(int value) {
        if (!isFull()) {
            this.tail = (this.tail + 1) % this.size;
            this.data.add(this.tail, value);

            return true;
        }

        return false;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        this.head = (this.head + 1) % this.size;
        this.data.remove(this.head);
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }

        return this.data.get(this.head);
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }

        return this.data.get(this.tail);
    }
}
