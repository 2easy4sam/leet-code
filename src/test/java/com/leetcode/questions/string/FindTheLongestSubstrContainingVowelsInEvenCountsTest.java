package com.leetcode.questions.string;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FindTheLongestSubstrContainingVowelsInEvenCountsTest {
    private FindTheLongestSubstrContainingVowelsInEvenCounts findTheLongestSubstrContainingVowelsInEvenCounts;

    @Before
    public void setUp() {
        findTheLongestSubstrContainingVowelsInEvenCounts = new FindTheLongestSubstrContainingVowelsInEvenCounts();
    }

    @Test
    public void test_1() {
        String s = "jszhctibantjpnnzcfgyvbuynnllqefzhhzblcokghiewwqmdpvxztapjiyzwjgzewumvbzymoraehpudjwtngqkdhhpsdfplwututnmrnyaumenebjmtnudgtiptniqydkzerwrzivvarvxdyloiydjezcnwmapsxeyyrmpzyhqamzbntchvbocjtblybccbsjljcrptlkyfulqhkthhuywgjjrkwjsavpivzhehfcim";

        assertThat(findTheLongestSubstrContainingVowelsInEvenCounts.findTheLongestSubstring(s)).isEqualTo(194);
    }
}