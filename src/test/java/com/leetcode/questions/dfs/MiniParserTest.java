package com.leetcode.questions.dfs;

import org.junit.Before;
import org.junit.Test;

public class MiniParserTest {
    private MiniParser miniParser;

    @Before
    public void setUp() {
        miniParser = new MiniParser();
    }

    @Test
    public void test_1() {
        String s = "[123,[456,[789]]]";

        miniParser.deserialize(s);
    }
}