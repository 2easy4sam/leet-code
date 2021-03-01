package com.leetcode.questions.backtracking;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RestoreIPAddressesTest {
    private RestoreIPAddresses restoreIPAddresses;

    @Before
    public void setUp() {
        restoreIPAddresses = new RestoreIPAddresses();
    }

    @Test
    public void test_1() {
        String s = "25525511135";

        assertThat(restoreIPAddresses.restoreIpAddresses(s)).contains("255.255.11.135", "255.255.111.35");
    }
}