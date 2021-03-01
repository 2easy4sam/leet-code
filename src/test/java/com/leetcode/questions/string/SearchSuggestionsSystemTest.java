package com.leetcode.questions.string;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SearchSuggestionsSystemTest {
    private SearchSuggestionsSystem searchSuggestionsSystem;

    @Before
    public void setUp() {
        searchSuggestionsSystem = new SearchSuggestionsSystem();
    }

    @Test
    public void test_1() {
        String[] products = {"mobile", "moneypot", "monitor", "mouse", "mousepad"};
        String searchWord = "mouse";

        assertThat(searchSuggestionsSystem.suggestedProducts(products, searchWord))
                .containsExactly(
                        Arrays.asList("mobile", "moneypot", "monitor"),
                        Arrays.asList("mobile", "moneypot", "monitor"),
                        Arrays.asList("mouse", "mousepad"),
                        Arrays.asList("mouse", "mousepad"),
                        Arrays.asList("mouse", "mousepad")
                );
    }
}