package com.leetcode.questions.design;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FileSystemTest {

    @Test
    public void test_1() {
        FileSystem fs = new FileSystem();
        fs.createPath("/a", 1);
        assertThat(fs.get("/a")).isEqualTo(1);
    }
}