package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IndexPairsOfAStringTest {
    private IndexPairsOfAString indexPairsOfAString;

    @Before
    public void setUp() {
        indexPairsOfAString = new IndexPairsOfAString();
    }

    @Test
    public void test_1() {
        String text = "thestoryofleetcodeandme";
        String[] words = new String[]{"story", "fleet", "leetcode"};

        assertThat(indexPairsOfAString.indexPairs(text, words)).containsExactly(new int[]{3, 7}, new int[]{9, 13}, new int[]{10, 17});
    }

    @Test
    public void test_2() {
        String text = "ababa";
        String[] words = new String[]{"aba", "ab"};

        assertThat(indexPairsOfAString.indexPairs(text, words)).containsExactly(new int[]{0, 1}, new int[]{0, 2}, new int[]{2, 3}, new int[]{2, 4});
    }

    @Test
    public void test_3() {
        String text = "a";
        String[] words = new String[]{"aba", "ab"};

        assertThat(indexPairsOfAString.indexPairs(text, words)).isEmpty();
    }

    @Test
    public void test_4() {
        String text = "baabaaaaaa";
        String[] words = new String[]{"b", "a", "ba", "bb", "aa"};

        assertThat(indexPairsOfAString.indexPairs(text, words)).containsExactly(
                new int[]{0, 0},
                new int[]{0, 1},
                new int[]{1, 1},
                new int[]{1, 2},
                new int[]{2, 2},
                new int[]{3, 3},
                new int[]{3, 4},
                new int[]{4, 4},
                new int[]{4, 5},
                new int[]{5, 5},
                new int[]{5, 6},
                new int[]{6, 6},
                new int[]{6, 7},
                new int[]{7, 7},
                new int[]{7, 8},
                new int[]{8, 8},
                new int[]{8, 9},
                new int[]{9, 9}
        );
    }
}