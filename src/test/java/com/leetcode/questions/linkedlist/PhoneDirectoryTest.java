package com.leetcode.questions.linkedlist;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneDirectoryTest {
    private PhoneDirectory phoneDirectory;

    @Test
    public void test_1() {
        phoneDirectory = new PhoneDirectory(3);

        assertThat(phoneDirectory.get()).isEqualTo(0);
        assertThat(phoneDirectory.get()).isEqualTo(1);
        assertThat(phoneDirectory.check(2)).isTrue();
        assertThat(phoneDirectory.get()).isEqualTo(2);
        phoneDirectory.release(1);
        phoneDirectory.release(2);
        phoneDirectory.release(0);
    }
}