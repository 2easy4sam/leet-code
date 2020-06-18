package com.leetcode.questions.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class KillProcessTest {
    private KillProcess killProcess;

    @Before
    public void setup() {
        killProcess = new KillProcess();
    }

    @Test
    public void test_1() {
        List<Integer> pid = Arrays.asList(1, 3, 10, 5);
        List<Integer> ppid = Arrays.asList(3, 0, 5, 3);
        int kill = 5;

        List<Integer> killed = killProcess.killProcess(pid, ppid, kill);

        assertThat(killed).containsExactly(5, 10);
    }
}