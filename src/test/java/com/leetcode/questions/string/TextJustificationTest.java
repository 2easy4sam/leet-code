package com.leetcode.questions.string;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TextJustificationTest {
    private TextJustification textJustification;

    @Before
    public void setUp() {
        textJustification = new TextJustification();
    }

    @Test
    public void test_1() {
        String[] words = new String[]{
                "This", "is", "an", "example", "of", "text", "justification."
        };

        List<String> actual = textJustification.fullJustify(words, 16);

        assertThat(actual.get(0)).isEqualTo("This    is    an");
        assertThat(actual.get(1)).isEqualTo("example  of text");
        assertThat(actual.get(2)).isEqualTo("justification.  ");
    }

    @Test
    public void test_2() {
        String[] words = new String[]{
                "What", "must", "be", "acknowledgment", "shall", "be"
        };

        List<String> actual = textJustification.fullJustify(words, 16);

        assertThat(actual.get(0)).isEqualTo("What   must   be");
        assertThat(actual.get(1)).isEqualTo("acknowledgment  ");
        assertThat(actual.get(2)).isEqualTo("shall be        ");
    }
}