package com.leetcode.datastructures;

public class MaxHeap {
    private int[] arr;
    private int end;
    private int capacity;

    public MaxHeap(int capacity) {
        arr = new int[capacity];
        end = 0;
        this.capacity = capacity;
    }

    // insert
    public void insert(int num) {
        if (end == capacity)
            throw new IndexOutOfBoundsException("Max capacity reached");
        arr[end++] = num;
        heapifyUp(end - 1);
    }

    // remove
    public int remove() {
        if (end < 0)
            throw new IndexOutOfBoundsException("Heap is empty");

        int max = arr[0];
        arr[0] = arr[--end];
        heapifyDown(0);

        return max;
    }

    // heapifyUp
    private void heapifyUp(int index) {
        if (index <= 0) return;
        int parentIdx = getParentIdx(index);

        if (arr[index] > arr[parentIdx]) {
            swap(index, parentIdx);
            heapifyUp(parentIdx);
        }
    }

    // heapifyDown
    private void heapifyDown(int index) {
        int l = getLeftChildIdx(index);
        int r = getRightChildIdx(index);

        if (l >= end) return;
        if (r < end) {
            // by this point we know that there is a right child
            // and the current element is greater than its left child
            if (arr[index] > arr[r] && arr[index] > arr[l]) return;
            if (arr[l] > arr[r]) {
                swap(index, l);
                heapifyDown(l);
            } else {
                swap(index, r);
                heapifyDown(r);
            }
        } else if (arr[index] < arr[l]) {
            swap(index, l);
            heapifyDown(l);
        }
    }

    // getParentIdx
    private int getParentIdx(int index) {
        return (index - (index % 2 == 0 ? 2 : 1)) / 2;
    }

    // getLeftChildIdx
    private int getLeftChildIdx(int index) {
        return index * 2 + 1;
    }

    // getRightChildIdx
    private int getRightChildIdx(int index) {
        return index * 2 + 2;
    }

    // swap
    private void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
