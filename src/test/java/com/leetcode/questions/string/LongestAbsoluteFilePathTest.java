package com.leetcode.questions.string;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LongestAbsoluteFilePathTest {
    private LongestAbsoluteFilePath underTest;

    @Before
    public void setUp() {
        underTest = new LongestAbsoluteFilePath();
    }

    @Test
    public void test_1() {
        assertThat(underTest.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext")).isEqualTo(20);
    }

    @Test
    public void test_2() {
        assertThat(underTest.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext")).isEqualTo(32);
    }

    @Test
    public void test_3() {
        assertThat(underTest.lengthLongestPath("a")).isEqualTo(0);
    }

    @Test
    public void test_4() {
        assertThat(underTest.lengthLongestPath("file1.txt\nfile2.txt\nlongfile.txt")).isEqualTo(12);
    }

    @Test
    public void test_5() {
        String input = "skd\n\talskjv\n\t\tlskjf\n\t\t\tklsj.slkj\n\t\tsdlfkj.sdlkjf\n\t\tslkdjf.sdfkj\n\tsldkjf\n\t\tlskdjf\n\t\t\tslkdjf.sldkjf\n\t\t\tslkjf\n\t\t\tsfdklj\n\t\t\tlskjdflk.sdkflj\n\t\t\tsdlkjfl\n\t\t\t\tlskdjf\n\t\t\t\t\tlskdjf.sdlkfj\n\t\t\t\t\tlsdkjf\n\t\t\t\t\t\tsldkfjl.sdlfkj\n\t\t\t\tsldfjlkjd\n\t\t\tsdlfjlk\n\t\t\tlsdkjf\n\t\tlsdkjfl\n\tskdjfl\n\t\tsladkfjlj\n\t\tlskjdflkjsdlfjsldjfljslkjlkjslkjslfjlskjgldfjlkfdjbljdbkjdlkjkasljfklasjdfkljaklwejrkljewkljfslkjflksjfvsafjlgjfljgklsdf.a";

        assertThat(underTest.lengthLongestPath(input)).isEqualTo(133);
    }

    @Test
    public void test_6() {
        String input = "file name with  space.txt";

        assertThat(underTest.lengthLongestPath(input)).isEqualTo(25);
    }
}