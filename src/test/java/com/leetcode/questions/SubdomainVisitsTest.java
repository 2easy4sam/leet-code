package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SubdomainVisitsTest {

    private SubdomainVisits subdomainVisits;

    @Before
    public void setUp() {
        subdomainVisits = new SubdomainVisits();
    }

    @Test
    public void test_1() {
        String[] cpdomains = new String[]{"9001 discuss.leetcode.com"};

        List<String> results = subdomainVisits.subdomainVisits(cpdomains);

        assertThat(results).containsExactly("9001 com", "9001 leetcode.com", "9001 discuss.leetcode.com");
    }
}