package com.leetcode.questions.design;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {
    private List<Integer> list;

    /** Initialize your data structure here. */
    public LinkedList() {
        list = new ArrayList<>();
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= list.size()) return -1;
        return list.get(index);
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        list.add(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        list.add(list.size(), val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > list.size()) return;
        list.add(index, val);
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < list.size()) {
            List<Integer> sub = list.subList(0, index);
            sub.addAll(list.subList(index + 1, list.size()));
            list = sub;
        }
    }
}
