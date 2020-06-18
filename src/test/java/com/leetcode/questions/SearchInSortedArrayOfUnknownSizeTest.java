package com.leetcode.questions;

import com.leetcode.questions.SearchInSortedArrayOfUnknownSize.ArrayReader;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchInSortedArrayOfUnknownSizeTest {
    private SearchInSortedArrayOfUnknownSize searchInSortedArrayOfUnknownSize;

    @Before
    public void setUp() {
        searchInSortedArrayOfUnknownSize = new SearchInSortedArrayOfUnknownSize();
    }

    @Test
    public void test_1() {
        int[] arr = IntStream.range(-9999, 10000).toArray();

        ArrayReader arrayReader = new ArrayReader(arr);

        assertThat(searchInSortedArrayOfUnknownSize.search(arrayReader, -9999)).isEqualTo(0);
        assertThat(searchInSortedArrayOfUnknownSize.search(arrayReader, 0)).isEqualTo(9999);
        assertThat(searchInSortedArrayOfUnknownSize.search(arrayReader, 9999)).isEqualTo(19998);
        assertThat(searchInSortedArrayOfUnknownSize.search(arrayReader, 9999 + 1)).isEqualTo(-1);
    }
}