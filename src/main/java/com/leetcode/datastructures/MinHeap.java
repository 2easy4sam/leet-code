package com.leetcode.datastructures;

public class MinHeap {
    private int end;
    private final int capacity;
    private int[] arr;

    public MinHeap(int capacity) {
        this.end = 0;
        this.capacity = capacity;
        this.arr = new int[capacity];
    }

    /*
    insert
    - check if it has reached max capacity
    - put it at the very end of the array
    - heapifyUp
    */
    public void insert(int num) {
        if (end >= capacity) {
            throw new IndexOutOfBoundsException("The heap has reached its max capacity");
        }

        arr[end] = num;
        // heapify up to make sure that the new entry is in the right place
        heapifyUp(end++);
    }

    /*
    remove (remove min)
    */
    public int remove() {
        if (end == 0)
            throw new IndexOutOfBoundsException("The heap is already empty");
        int top = arr[0];
        arr[0] = arr[--end];
        heapifyDown(0);
        return top;
    }

    public int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    public int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    /*
    heapifyUp
    */
    public void heapifyUp(int index) {
        // index 0 doesn't have a parent
        while (index != 0) {
            int parentIdx = getParentIdx(index);

            if (arr[parentIdx] > arr[index]) {
                swap(arr, parentIdx, index);
                index = parentIdx;
            } else {
                break;
            }
        }
    }

    /*
    heapifyDown
     */
    public void heapifyDown(int index) {
        // compare the new root with its left and right child
        // whichever is smaller gets moved up/swapped
        int l = getLeftChildIndex(index);
        int r = getRightChildIndex(index);

        if (l >= end || arr[index] < arr[l]) {
            // it doesn't have a left child
            // so it definitely doesn't have a right child
            return;
        } else if (r >= end || arr[l] < arr[r]) {
            // it doesn't have a right child
            swap(arr, index, l);
            heapifyDown(l);
        } else {
            swap(arr, index, r);
            heapifyDown(r);
        }
    }

    /*
    Get the parent index of the element at the given index
    */
    public int getParentIdx(int index) {
        return (index - (index % 2 == 0 ? 2 : 1)) / 2;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
