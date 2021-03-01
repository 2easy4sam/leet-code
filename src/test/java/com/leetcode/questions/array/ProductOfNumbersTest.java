package com.leetcode.questions.array;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductOfNumbersTest {
    private ProductOfNumbers productOfNumbers;

    @Test
    public void test_1() {
        productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(1);
        productOfNumbers.add(2);
        productOfNumbers.add(3);

        assertThat(productOfNumbers.getProduct(2)).isEqualTo(6);

        productOfNumbers.add(4);
        productOfNumbers.add(5);

        assertThat(productOfNumbers.getProduct(3)).isEqualTo(60);
    }

    @Test
    public void test_2() {
        productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);
        productOfNumbers.add(0);
        productOfNumbers.add(2);
        productOfNumbers.add(5);
        productOfNumbers.add(4);

        assertThat(productOfNumbers.getProduct(2)).isEqualTo(20);
        assertThat(productOfNumbers.getProduct(3)).isEqualTo(40);
        assertThat(productOfNumbers.getProduct(4)).isEqualTo(0);

        productOfNumbers.add(8);

        assertThat(productOfNumbers.getProduct(2)).isEqualTo(32);
    }
}