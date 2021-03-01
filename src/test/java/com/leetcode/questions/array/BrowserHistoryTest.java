package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BrowserHistoryTest {
    private BrowserHistory browserHistory;

    @Before
    public void setUp() {
        browserHistory = new BrowserHistory("leetcode");
    }

    @Test
    public void test_1() {
        browserHistory.visit("www.google.com");
        browserHistory.visit("www.facebook.com");
        browserHistory.visit("www.youtube.com");

        assertThat(browserHistory.back(1)).isEqualTo("www.facebook.com");
        assertThat(browserHistory.back(1)).isEqualTo("www.google.com");
        assertThat(browserHistory.forward(1)).isEqualTo("www.facebook.com");

        browserHistory.visit("www.linkedin.com");

        assertThat(browserHistory.forward(2)).isEqualTo("www.linkedin.com");
        assertThat(browserHistory.back(2)).isEqualTo("www.google.com");
        assertThat(browserHistory.back(7)).isEqualTo("www.leetcode.com");
    }
}