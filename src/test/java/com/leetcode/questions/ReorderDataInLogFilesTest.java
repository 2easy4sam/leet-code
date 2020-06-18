package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReorderDataInLogFilesTest {
    private ReorderDataInLogFiles reorderDataInLogFiles;

    @Before
    public void setUp() {
        reorderDataInLogFiles = new ReorderDataInLogFiles();
    }

    @Test
    public void test_1() {
        String[] logs = new String[]{
                "dig1 8 1 5 1",
                "let1 art can",
                "dig2 3 6",
                "let2 own kit dig",
                "let3 art zero"
        };

        String[] actual = reorderDataInLogFiles.reorderLogFiles(logs);

        assertThat(actual).containsExactly(
                "let1 art can",
                "let3 art zero",
                "let2 own kit dig",
                "dig1 8 1 5 1",
                "dig2 3 6"
        );
    }

    @Test
    public void test_2() {
        String[] logs = new String[]{
                "a1 9 2 3 1",
                "g1 act car",
                "zo4 4 7",
                "ab1 off key dog",
                "a8 act zoo"
        };

        String[] actual = reorderDataInLogFiles.reorderLogFiles(logs);

        assertThat(actual).containsExactly(
                "g1 act car",
                "a8 act zoo",
                "ab1 off key dog",
                "a1 9 2 3 1",
                "zo4 4 7"
        );
    }

    @Test
    public void test_3() {
        String[] logs = new String[]{
                "j je",
                "b fjt",
                "7 zbr",
                "m le",
                "o 33"
        };

        String[] actual = reorderDataInLogFiles.reorderLogFiles(logs);

        assertThat(actual).containsExactly(
                "b fjt",
                "j je",
                "m le",
                "7 zbr",
                "o 33"
        );
    }
}