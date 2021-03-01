package com.leetcode.questions.array;

public class ProductOfNumbers {

    private int i;
    private int[] products;

    public ProductOfNumbers() {
        i = 1;
        products = new int[40001];
    }

    public void add(int num) {
        products[i] = Math.max(products[i - 1], 1) * num;
        i++;
    }

    public int getProduct(int k) {
        int idx = i - 1 - k;
        int tmp = idx;
        while (tmp < i - 1) {
            if (products[tmp] == 0 && tmp > idx) return 0;
            tmp++;
        }

        return products[idx] == 0 ? products[i - 1] : products[i - 1] / products[idx];
    }
}
