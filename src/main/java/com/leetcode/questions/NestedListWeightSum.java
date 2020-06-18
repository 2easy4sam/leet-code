package com.leetcode.questions;

import java.util.ArrayList;
import java.util.List;

class NestedListWeightSum {

    int depthSum(List<NestedInteger> nestedList) {
        return depthSumHelper(nestedList, 1);
    }

    private int depthSumHelper(List<NestedInteger> nestedList, int depth) {
        int depthSum = 0;

        for (NestedInteger current : nestedList) {
            if (current.isInteger()) {
                depthSum += current.getInteger();
            } else {
                depthSum += depthSumHelper(current.getList(), depth + 1) * (depth + 1);
            }
        }

        return depthSum;
    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    static class NestedInteger {
        private List<NestedInteger> nestedList;
        private Integer value;

        // Constructor initializes an empty nested list.
        public NestedInteger() {
            nestedList = new ArrayList<>();
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
            this.value = value;
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return nestedList == null;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return nestedList == null ? value : null;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
            this.value = value;
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
            nestedList.add(ni);
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return nestedList;
        }
    }
}
