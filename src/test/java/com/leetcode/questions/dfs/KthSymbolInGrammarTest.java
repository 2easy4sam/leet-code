package com.leetcode.questions.dfs;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KthSymbolInGrammarTest {
    private KthSymbolInGrammar kthSymbolInGrammar;

    @Before
    public void setUp() {
        kthSymbolInGrammar = new KthSymbolInGrammar();
    }

    @Test
    public void test_1() {
        int n = 1, k = 1;

        assertThat(kthSymbolInGrammar.kthGrammar(n, k)).isEqualTo('0');
    }
}