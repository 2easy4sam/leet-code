package com.leetcode.questions.dfs;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberOfAtomsTest {
    private NumberOfAtoms underTest;

    @Before
    public void setUp() {
        underTest = new NumberOfAtoms();
    }

    @Test
    public void test_1() {
        String formula = "O2O2";

        assertThat(underTest.countOfAtoms(formula)).isEqualTo("O4");
    }

    @Test
    public void test_2() {
        String formula = "Mg(OH)2";

        assertThat(underTest.countOfAtoms(formula)).isEqualTo("H2MgO2");
    }
}