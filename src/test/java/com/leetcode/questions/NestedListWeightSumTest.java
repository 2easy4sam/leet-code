package com.leetcode.questions;

import com.leetcode.questions.NestedListWeightSum.NestedInteger;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NestedListWeightSumTest {
    private NestedListWeightSum nestedListWeightSum;

    @Before
    public void setUp() {
        nestedListWeightSum = new NestedListWeightSum();
    }

    @Test
    public void test_withEmptyList() {
        assertThat(nestedListWeightSum.depthSum(Collections.emptyList())).isEqualTo(0);
    }

    @Test
    public void test_with1LevelOnly() {
        List<NestedInteger> nestedList = new ArrayList<>();
        nestedList.add(new NestedInteger(1));
        nestedList.add(new NestedInteger(2));
        nestedList.add(new NestedInteger(3));
        nestedList.add(new NestedInteger(4));
        nestedList.add(new NestedInteger(5));
        nestedList.add(new NestedInteger(6));

        assertThat(nestedListWeightSum.depthSum(nestedList)).isEqualTo(21);
    }

    @Test
    public void test_() {
        List<NestedInteger> nestedList = new ArrayList<>();
        nestedList.add(new NestedInteger(1));

        NestedInteger nestedInteger4 = new NestedInteger(4);

        NestedInteger nestedIntegerLevel2 = new NestedInteger();
        nestedIntegerLevel2.add(nestedInteger4);
        nestedList.add(nestedIntegerLevel2);

        NestedInteger nestedIntegerLevel3 = new NestedInteger();
        nestedIntegerLevel3.add(new NestedInteger(6));
        nestedList.add(nestedIntegerLevel3);

        assertThat(nestedListWeightSum.depthSum(nestedList)).isEqualTo(27);
    }
}